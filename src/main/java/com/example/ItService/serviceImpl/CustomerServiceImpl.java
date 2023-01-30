package com.example.ItService.serviceImpl;

import com.example.ItService.model.Customer;
import com.example.ItService.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.example.ItService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Long getOrCreateCustomer(String name, String email, String phone) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    @Override
    public Optional<Customer> findFirstByPhone(String phone){
        return  customerRepository.findFirstByPhone(phone);
    }

}
