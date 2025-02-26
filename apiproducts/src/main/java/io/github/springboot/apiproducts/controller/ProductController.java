package io.github.springboot.apiproducts.controller;

import io.github.springboot.apiproducts.model.Product;
import io.github.springboot.apiproducts.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Product received " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);

        return product;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id) {
//        Optional<Product> product = productRepository.findById(id);
//        return product.isPresent() ? product.get() : null
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletedById(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> search(@RequestParam("name") String name) {
        return productRepository.findByName(name);
    }

}
