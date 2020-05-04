/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Actor;
//import com.vasslatam.sakila.endpoint.request.ActorRequest;
import com.vasslatam.sakila.service.ActorService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USERVASSPERU
 */
@RestController
@RequestMapping("/api")
public class ActorEndpoint {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorEndpoint.class);
    
    @Autowired
    private ActorService actorService;
    
    @PostConstruct
    public void init(){
        LOGGER.info("Iniciando ActorEndpoint [OK]");
    }
    
    @GetMapping(path = "/actor", produces = "application/json")
    public List<Actor> finAll(){
        return actorService.findAll();
        
    }
    
    @PostMapping(path = "/actor", consumes = "application/json" ,produces = "application/json")
    public Actor create(@RequestBody Actor request){
        Actor actor = actorService.create(request.getFirstName(),request.getLastName());
        return actor;
    }
    /*
    public Actor create(ActorRequest request){
        Actor actor = actorService.create(request.getFirstName(), request.getLastName());
        return actor;
                
    }
    */
            
}
