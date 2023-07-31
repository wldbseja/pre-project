package spring.server.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthHealthCheck {
    @GetMapping("/")
    public String healthCheck(){
        return "hello : logout";
    }
}
