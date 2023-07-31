package spring.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import spring.server.auth.CustomAuthorityUtils;
import spring.server.auth.filter.JwtAuthenticationFilter;
import spring.server.auth.filter.JwtVerificationFilter;
import spring.server.auth.handler.*;
import spring.server.auth.jwt.JwtTokenizer;
import spring.server.auth.oauth2.handler.OAuth2UserSuccessHandler;
import spring.server.redis.RedisService;
import spring.server.user.repository.UserRepository;
import spring.server.user.service.UserService;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils; // 추가
    private final UserService userService;
    private final RedisService redisService;
    private final UserRepository userRepository;

//    public SecurityConfiguration(JwtTokenizer jwtTokenizer, CustomAuthorityUtils authorityUtils, UserService userService, RedisService redisService, UserRepository userRepository) {
//        this.jwtTokenizer = jwtTokenizer;
//        this.authorityUtils = authorityUtils;
//        this.userService = userService;
//        this.redisService = redisService;
//        this.userRepository = userRepository;
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin() // (1)
                .and()
                .csrf().disable()        // (2)
                .cors(withDefaults())    // (3)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()   // (4)
                .httpBasic().disable()   // (5)
                .exceptionHandling()
                .authenticationEntryPoint(new UserAuthenticationEntryPoint())  // (1) 추가
                .accessDeniedHandler(new UserAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
//                .authorizeHttpRequests(authorize -> authorize
////                        .antMatchers(HttpMethod.GET, "/user/**").permitAll()
////                        .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
////                        .antMatchers(HttpMethod.PATCH, "/user/edit/**").hasRole("USER")
////                        .antMatchers(HttpMethod.DELETE, "/user/**").hasRole("USER")
//                        .antMatchers(HttpMethod.GET, "/answers/**").hasRole("USER")
//                        .anyRequest().permitAll()
//                )
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .logout()
                .logoutUrl("/auth/logout")
                .addLogoutHandler(new UserLogoutHandler(redisService, jwtTokenizer))
                .logoutSuccessUrl("/");
//                .and()
//                .oauth2Login(oauth2 -> oauth2
//                        .successHandler(new OAuth2UserSuccessHandler(jwtTokenizer, authorityUtils, userService))  // (1)
//                );
        return http.build();
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {  // (2-1)
        @Override
        public void configure(HttpSecurity builder) throws Exception {  // (2-2)
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);  // (2-3)

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer, redisService);  // (2-4)
            jwtAuthenticationFilter.setFilterProcessesUrl("/auth/login");          // (2-5)
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new UserAuthenticationSuccessHandler());  // (3) 추가
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new UserAuthenticationFailtureHandler());  // (4) 추가

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils, redisService, userRepository);  // (2) 추가

            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);// (2-6)
//                    .addFilterAfter(jwtVerificationFilter, OAuth2LoginAuthenticationFilter.class); // (2)
        }
    }



    public void addCorsMapptings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST", "PATCH", "DELETE","OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Authorization");
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PATCH", "DELETE","OPTIONS"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.addExposedHeader("Authorization");

        source.registerCorsConfiguration("/**", configuration);         // 주의 사항: 콘텐츠 표시 오류로 인해 '/**'를 '\/**'로 표기했으니 실제 코드 구현 시에는 '\(역슬래시)'를 빼 주세요.

        return source;
    }
}
