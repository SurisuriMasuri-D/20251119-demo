package com.example.loginService;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // 앞서 만든 UserRepository 주입

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. UserRepository를 사용하여 데이터베이스에서 사용자 정보를 조회합니다.
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));

        // 2. Spring Security의 UserDetails 객체로 변환하여 반환합니다.
        // 이때, User 엔티티가 UserDetails를 구현하거나, UserDetails를 반환하는 빌더를 사용해야 합니다.
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER") // 사용자 권한 설정 (예: "USER", "ADMIN")
                .build();
    }
}