/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Address;
import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.domain.Store;
import com.vasslatam.sakila.repository.CustomerRepository;
import com.vasslatam.sakila.service.CustomerService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
            
    @Override
    public Customer findbycustomerId(int customerId) {
        return customerRepository.getOne(customerId);
    }

    @Override
    public BigDecimal getcustomer(int customerId, LocalDateTime date) {
        return customerRepository.getcustomer(customerId, date);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
       customerRepository.deleteById(id);
    }

    @Override
    public Customer create(Store store, String firtName, String lastName, String email, Address address) {
        Customer customer = new Customer();
        customer.setStore(store);
        customer.setFirstName(firtName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setLastDate(LocalDateTime.now());
        customer.setCreateDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findbycustomeraddress(String firstname, String address, Integer store) {
        return customerRepository.findbycustomeraddress(firstname, address, store);
    }
    
}
