package com.loopy.domain.products;

import com.loopy.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT b FROM Products b ORDER BY b.id DESC")
    List<Products> findAllDesc();
}
