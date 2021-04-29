package com.loopy.config.auth;

import com.loopy.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//설정 코드

@RequiredArgsConstructor
//SPRING SECURITY 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    // URL 별 권한 관리 설정 옵션 시작점.
                    .authorizeRequests()
                    // 관한 관리 대상 지정 옵션
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/posts/ml", "/posts/dl").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.ADMIN.name())
                    // 설정된 값들 이외 나머지 URL들.
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
