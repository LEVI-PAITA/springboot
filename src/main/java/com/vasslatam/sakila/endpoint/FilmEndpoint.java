/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Film;
//import com.vasslatam.sakila.domain.FilmActor;
import com.vasslatam.sakila.service.FilmService;
import com.vasslatam.sakila.type.Rating;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USERVASSPERU
 */
@RestController
@RequestMapping("/api")
public class FilmEndpoint {
    
    @Autowired
    private FilmService filmService;
    
    @GetMapping("/film")
    public List<Film> findAll(){
        return filmService.findAll();
    }
    
    @GetMapping("/by-actor")
    public List<Film> findByActor(@RequestParam("actor") String actorName){
       List<Film>films = filmService.findByActorName(actorName);
       return films; 
    }
    
    @GetMapping("/store")
    public List<Film> findByStore(@RequestParam("storeId") int storeId){
        List<Film> films = filmService.findByStoreId(storeId);
        return films;
    }
    
    @GetMapping("/by-films")
    public List<Film> findByFilm(@RequestParam("actor") String actor,
                                      @RequestParam("description") String description,
                                      @RequestParam("title") String title,
                                      @RequestParam("rating") Rating rating){
        List<Film> filmsActors = filmService.findByFilm(actor, description, title, rating);
        return filmsActors;
    }
    
            
}
