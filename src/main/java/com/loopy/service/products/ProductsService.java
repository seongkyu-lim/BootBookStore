package com.loopy.service.products;

import com.loopy.domain.products.Products;
import com.loopy.domain.products.ProductsRepository;
import com.loopy.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) {
        return productsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProductsUpdateRequestDto requestDto){
        Products products = productsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        products.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public ProductsResponseDto findById (Long id) {
        Products entity = productsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        return new ProductsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllDesc() {
        return productsRepository.findAllDesc().stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
