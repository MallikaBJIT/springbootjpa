package com.example.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
