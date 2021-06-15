package com.loopy.web.dto;

import com.loopy.domain.products.Products;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Getter
public class ProductsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public ProductsListResponseDto(Products entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}

