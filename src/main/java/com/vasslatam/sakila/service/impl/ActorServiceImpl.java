/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Actor;
import com.vasslatam.sakila.repository.ActorRepository;
import com.vasslatam.sakila.service.ActorService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class ActorServiceImpl implements ActorService{
    
    @Autowired
    private ActorRepository actorRepository;
    
    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor create(String firstName, String lastName) {
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(LocalDateTime.now());
        return actorRepository.save(actor);
    }
    
}
