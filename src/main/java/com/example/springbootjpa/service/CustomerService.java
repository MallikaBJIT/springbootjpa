package com.example.springbootjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootjpa.exception.CustomNotExistException;
import com.example.springbootjpa.model.Customer;
import com.example.springbootjpa.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            throw new CustomNotExistException("Customer id already exists");
        }
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomNotExistException("Customer id doesn't exists");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomNotExistException("Customer id doesn't exists");
        }
        customerRepository.deleteById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomNotExistException("customer not exists");
        }
        return customer.get();
    }
}
