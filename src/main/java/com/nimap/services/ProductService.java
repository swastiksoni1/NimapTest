package com.nimap.services;

import com.nimap.model.Product;
import com.nimap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Page<Product> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }


    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());  // Set associated category
        return productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        Product product = getProductById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
