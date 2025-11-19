package com.example.loginService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                // 특정 경로는 인증 없이 접근 허용
                .requestMatchers("/", "/home", "/public/**").permitAll()
                // 그 외 모든 요청은 인증 필요
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // 사용자 정의 로그인 페이지 경로 설정 (옵션)
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // BCryptPasswordEncoder는 비밀번호를 안전하게 해시합니다.
//        return new BCryptPasswordEncoder();
//    }
}