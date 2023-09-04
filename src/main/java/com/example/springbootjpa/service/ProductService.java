package com.example.springbootjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootjpa.exception.CustomNotExistException;
import com.example.springbootjpa.model.Product;
import com.example.springbootjpa.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new CustomNotExistException("Product id already exists");
        }
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new CustomNotExistException("Product id doesn't exist");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new CustomNotExistException("Product id doesn't exist");
        }
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Integer id) {
        Optional<Product> productById = productRepository.findById(id);
        Product product = null;
        if (productById.isPresent()) {
            throw new CustomNotExistException("product doesn't exist");
        }
        return product;
    }
}
