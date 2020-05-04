/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository;

import com.vasslatam.sakila.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USERVASSPERU
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{
    
}
