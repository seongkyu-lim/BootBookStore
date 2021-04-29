package com.loopy.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//사용자 권한관리 enum 클래스

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}