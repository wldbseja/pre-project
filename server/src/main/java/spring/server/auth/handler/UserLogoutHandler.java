package spring.server.auth.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import spring.server.auth.jwt.JwtTokenizer;
import spring.server.redis.RedisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
public class UserLogoutHandler implements LogoutHandler {
    private final RedisService redisService;
    private final JwtTokenizer jwtTokenizer;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        String accessToken = request.getHeader("Authorization");
        System.out.println("UserLogoutHandler.logout");
        String refreshToken = request.getHeader("Refresh");
        String username = jwtTokenizer.getUsername(refreshToken);
        System.out.println(username);

        redisService.setDataWithExpiration(refreshToken, "logout", Long.valueOf(jwtTokenizer.getRefreshTokenExpirationMinutes()));
        redisService.deleteData(username);
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

    }
}
