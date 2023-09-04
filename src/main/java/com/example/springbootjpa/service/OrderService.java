package com.example.springbootjpa.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootjpa.exception.CustomNotExistException;
import com.example.springbootjpa.model.OrderEntity;
import com.example.springbootjpa.repository.OrderRepository;
import com.example.springbootjpa.repository.ProductRepository;

import com.example.springbootjpa.model.Product;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void productsNotEmpty(OrderEntity orderEntity) {
        Iterator<Product> products = orderEntity.getProducts().iterator();
        while (products.hasNext()) {
            Product product = products.next();
            boolean p = productRepository.findById(product.getId()).isPresent();
            System.out.println(p);
            if (!p) {
                products.remove();
            }
        }
        if (orderEntity.getProducts().isEmpty()) {
            throw new CustomNotExistException("Products field is empty");
        }
    }

    public void createOrder(OrderEntity orderEntity) {
        productsNotEmpty(orderEntity);
        orderRepository.save(orderEntity);
    }

    public void updateOrder(OrderEntity orderEntity) {
        if (!orderRepository.existsById(orderEntity.getId())) {
            throw new CustomNotExistException("Order doesn't exist");
        }
        productsNotEmpty(orderEntity);
        orderRepository.save(orderEntity);
    }

    public void deleteOrder(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new CustomNotExistException("Order doesn't exist");
        }
        orderRepository.deleteById(id);
    }

    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();
    }

    public OrderEntity findOrderById(Integer id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (orderEntity.isEmpty()) {
            throw new CustomNotExistException("Order not exists");
        }
        return orderEntity.get();
    }

    public List<OrderEntity> getAllOrderByCustomer(Integer customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}
