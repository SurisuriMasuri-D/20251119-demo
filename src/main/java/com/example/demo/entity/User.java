package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "app_user") // 테이블 이름은 필요에 따라 변경 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Spring Security의 UserDetailsService에서 사용되는 중요한 필드
    @Column(nullable = false, unique = true)
    private String username;

    // 암호화된 비밀번호가 저장될 필드
    @Column(nullable = false)
    private String password;

    private String role; // 권한 관리를 위한 필드 (예: "USER", "ADMIN")

    // Getters and Setters (생략)
    // 생성자 (생략)
}