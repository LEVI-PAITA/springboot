/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint.request;

import com.vasslatam.sakila.domain.Address;
import com.vasslatam.sakila.domain.Store;

/**
 *
 * @author USERVASSPERU
 */
public class CustomerRequest {
    
    private String firstName;
    private String lastName;
    private String email;
    private Store store;
    private Address address;
    
    public CustomerRequest(){
        
    }
    
    public CustomerRequest(Store store,String firstName, String lastName, String email, Address address ){
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
