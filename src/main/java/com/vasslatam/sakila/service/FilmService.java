/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Film;
//import com.vasslatam.sakila.domain.FilmActor;
import com.vasslatam.sakila.type.Rating;
import java.util.List;

/**
 *
 * @author USERVASSPERU
 */
public interface FilmService {
    
    List<Film> findAll();
    
    List<Film> findByActorName(String actorName);
    
    List<Film> findByStoreId(int storeId);
    
    List<Film> findByFilm(String actor, String description, String title, Rating rating);
}
