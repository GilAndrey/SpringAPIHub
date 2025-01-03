package io.github.springboot.apiproducts.repository;

import io.github.springboot.apiproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
