package com.loopy.web.dto;

import com.loopy.domain.products.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String category;
    private String img;

    @Builder
    public ProductsSaveRequestDto(String title, String content, String author, String category, String img) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
        this.img = img;

    }

    public Products toEntity() {
        return Products.builder()
                .title(title)
                .content(content)
                .author(author)
                .category(category)
                .img(img)
                .build();
    }
}
