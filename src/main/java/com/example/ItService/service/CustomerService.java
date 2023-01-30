package com.example.ItService.service;

import com.example.ItService.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Long getOrCreateCustomer(String name,String email,String phone);
    Optional<Customer> findFirstByPhone(String phone);
    void addCustomer(Customer customer);

}
