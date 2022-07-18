package com.web.finances.domain.repository;

import com.web.finances.domain.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository  extends JpaRepository<Products, Long> {
}
