/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository.custom;

import com.vasslatam.sakila.domain.Customer;
import java.util.List;

/**
 *
 * @author USERVASSPERU
 */
public interface CustomerRepositoryCustom {
    
    List<Customer> findbycustomeraddress(String firstname, String address, Integer store);
}
