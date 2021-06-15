package com.loopy.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ProductsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
