package com.example.ItService.controllers;

import com.example.ItService.model.Customer;
import com.example.ItService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers/{phone}")
    public ResponseEntity<Optional<Customer>> allCustomers(@PathVariable(value = "phone") String phone){
        Optional<Customer> customer = customerService.findFirstByPhone(phone);
        return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK) ;
    }
}
