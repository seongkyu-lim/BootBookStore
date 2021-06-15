package com.loopy.domain.products;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//다른 설정안하면 h2로 자동으로 싫행.
@SpringBootTest
public class ProductsRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @After
    public void cleanup() {
        productsRepository.deleteAll();
    }

    @Test
    public void 책글저장_불러오기() {
        //given
        String title = "테스트 책";
        String content = "테스트 본문";

        productsRepository.save(Products.builder()
                .title(title)
                .content(content)
                .author("soengkyu@gmail.com")
                .build());

        //when
        List<Products> productsList = productsRepository.findAll();

        //then
        Products products = productsList.get(0);
        assertThat(products.getTitle()).isEqualTo(title);
        assertThat(products.getContent()).isEqualTo(content);
    }
}
