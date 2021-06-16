package com.loopy.domain.products;

import com.loopy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Products extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length= 500, nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //선언하지 않으면 기본값.
    private String category;

    private String img;

    @Builder
    public Products(String title, String content, String author, String category, String img){
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.img = img;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
