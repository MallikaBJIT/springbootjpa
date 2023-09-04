package com.example.springbootjpa.controller;

import com.example.springbootjpa.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpa.model.OrderEntity;
import com.example.springbootjpa.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create_order")
    public ResponseEntity<?> create(@RequestBody OrderEntity orderEntity) {
        orderService.createOrder(orderEntity);
        return ResponseHandler.generateResponse("order is created", HttpStatus.CREATED, orderEntity);
    }

    @PutMapping("/update/order")
    public ResponseEntity<?> update(@RequestBody OrderEntity orderEntity) {
        orderService.updateOrder(orderEntity);
        return ResponseHandler.generateResponse("order is updated", HttpStatus.OK, orderEntity);
    }

    @DeleteMapping("/delete/order/{id}")
    public ResponseEntity<?> create(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseHandler.generateResponse("order is deleted", HttpStatus.OK);
    }

    @GetMapping("/get/order")
    public ResponseEntity<?> get() {
        return ResponseHandler.generateResponse("List of orders",
                HttpStatus.OK, orderService.getAllOrder());
    }

    @GetMapping("/get/order/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseHandler.generateResponse("Order with id " + id,
                HttpStatus.OK, orderService.findOrderById(id));
    }
}
