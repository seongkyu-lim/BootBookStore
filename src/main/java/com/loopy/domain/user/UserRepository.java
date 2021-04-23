package com.loopy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //email 이용해 이미 생성된 사용자인지 신규인지 판단.
    Optional<User> findByEmail(String email);
}
