/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Actor;
import java.util.List;

/**
 *
 * @author USERVASSPERU
 */
public interface ActorService {
    
    List<Actor> findAll();
    Actor create(String firstName, String lastName);
}
