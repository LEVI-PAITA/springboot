/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Address;
import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.domain.Store;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author USERVASSPERU
 */
public interface CustomerService {
    
    Customer findbycustomerId(int customerId);
    
    BigDecimal getcustomer(int customerId, LocalDateTime date);
    
    List<Customer> findAll();
    
    Customer findById(Integer id);
    
    Customer save(Customer customer);
    
    Customer create(Store store, String firtName,String lastName,String email, Address address);
    
    public void delete(Integer id);
    
    public List<Customer> findbycustomeraddress(String firstname, String address, Integer store);
}
