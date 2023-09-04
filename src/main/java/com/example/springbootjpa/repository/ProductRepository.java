package com.example.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootjpa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
