package com.example.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjpa.model.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByCustomerId(Integer customerId);
}
