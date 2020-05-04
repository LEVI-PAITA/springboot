/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Country;
import com.vasslatam.sakila.repository.CountryRepository;
import com.vasslatam.sakila.service.CountryService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;
    
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    
    
    @Override
    public Page<Country> findAll(Pageable pageable) {
       return countryRepository.findAll(pageable);
    }

    @Override
    public Country findById(Integer id) {
       return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country country) {
        country.setLastUpdate(LocalDateTime.now());
        return countryRepository.save(country);
    }

    @Override
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    
}
