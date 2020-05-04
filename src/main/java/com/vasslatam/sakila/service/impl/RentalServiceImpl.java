/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Rental;
import com.vasslatam.sakila.repository.RentalRepository;
import com.vasslatam.sakila.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class RentalServiceImpl implements RentalService{
    
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public int lastInsert() {
        return rentalRepository.lastInsert();
    }

    @Override
    public Rental findById(int rentalId) {
         return rentalRepository.getOne(rentalId);
    }

    @Override
    public Rental create(Rental rental) {
        return rentalRepository.save(rental);
    }
    
}
