package com.loopy.web;

import com.loopy.service.products.ProductsService;
import com.loopy.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductsApiController {

    private final ProductsService productsService;

    @PostMapping("/api/v1/products")
    public Long save(@RequestBody ProductsSaveRequestDto requestDto){
        return productsService.save(requestDto);
    }

    @PutMapping("/api/v1/products/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProductsUpdateRequestDto requestDto){
        return productsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/products/{id}")
    public ProductsResponseDto findById(@PathVariable Long id){
        return productsService.findById(id);
    }

    @GetMapping("/api/v1/products/list")
    public List<ProductsListResponseDto> findAll() {
        return productsService.findAllDesc();
    }

}
