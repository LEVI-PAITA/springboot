/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Rental;

/**
 *
 * @author USERVASSPERU
 */
public interface RentalService {
    
    int lastInsert();
    
    Rental findById(int rentalId);
    
    Rental create(Rental rental);
}
