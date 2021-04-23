package com.loopy.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Posts는 DB의 테이블과 매칭될 클래스(entity 클래스).
//실제 쿼리를 날리기보다는 이 클래스의 수정을 통해 작업.

//Lombok, makes code simple
@Getter
@NoArgsConstructor
//JPA annotation, 테이블과 링크될 클래스임을 나타냄.
@Entity
public class Posts {

    //JPA ANNOTATION, 해당 테이블의 PK 필드
    @Id
    // PK 생성규칙
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블 컬럼 나타냄. 선언하지 않으면 기본값으로 선언됨.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable =false)
    private  String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
