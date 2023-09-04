package com.example.springbootjpa.controller;

import java.util.List;

import com.example.springbootjpa.model.OrderEntity;
import com.example.springbootjpa.response.ResponseHandler;
import com.example.springbootjpa.service.OrderService;
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

import com.example.springbootjpa.model.Customer;
import com.example.springbootjpa.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/create_customer")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseHandler.generateResponse("customer is created", HttpStatus.CREATED);
    }

    @PutMapping("/update/customer")
    public ResponseEntity<?> update(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseHandler.generateResponse("customer is updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseHandler.generateResponse("customer is removed",HttpStatus.OK);
    }

    @GetMapping("/get/customer")
    public ResponseEntity<?> get() {
        return ResponseHandler.generateResponse("All customer's details"
                , HttpStatus.OK, customerService.getAllCustomers());
    }

    @GetMapping("/get/customer/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseHandler.generateResponse("Customer details",
                HttpStatus.OK, customerService.findCustomerById(id));
    }

    @GetMapping("/get/order/customer/{id}")
    public ResponseEntity<?> getByCustomer(@PathVariable Integer id) {
        List<OrderEntity> orderEntities = orderService.getAllOrderByCustomer(id);
        return ResponseHandler.generateResponse("List of orders by customer"
                , HttpStatus.OK, orderEntities);
    }
}
