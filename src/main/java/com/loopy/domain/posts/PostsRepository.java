package com.loopy.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// mybatis에서의 dao. DB layer 접근자. / Posts 클래스로 DB를 접근하게 해줌.
//JpaRepository<entity 클래스, PK타입>
// 기본적인 CRUD 메소드 자동으로 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}