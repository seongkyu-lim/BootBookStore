package com.loopy.web.dto;

import com.loopy.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public ProductsResponseDto(Products entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content  = entity.getContent();
        this.author = entity.getAuthor();
    }
}
