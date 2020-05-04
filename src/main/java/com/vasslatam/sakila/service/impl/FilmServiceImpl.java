/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Film;
import com.vasslatam.sakila.repository.FilmRepository;
import com.vasslatam.sakila.service.FilmService;
import com.vasslatam.sakila.type.Rating;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository filmRepository;
    
    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> findByActorName(String actorName) {
       return filmRepository.findByActorName(actorName);
    }

    @Override
    public List<Film> findByStoreId(int storeId) {
        return filmRepository.findByStoreId(storeId);
    }

    @Override
    public List<Film> findByFilm(String actor, String description, String title, Rating rating) {
        return filmRepository.findByFilm(actor, description, title, rating);
    }
    
}
