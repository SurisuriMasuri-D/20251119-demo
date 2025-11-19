package com.example.demo.repository;

import com.example.demo.entity.User; // 실제 User 엔티티 경로로 변경
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// JpaRepository<[관리할 엔티티 클래스], [엔티티 ID의 데이터 타입]>
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Spring Security의 UserDetailsService에서 사용자를 찾기 위해 필요한 쿼리 메소드입니다.
     * Spring Data JPA는 메소드 이름 규칙에 따라 자동으로 SQL을 생성합니다.
     * SELECT * FROM app_user WHERE username = ?
     */
    Optional<User> findByUsername(String username);
}