/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository;

import com.vasslatam.sakila.domain.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USERVASSPERU
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
       @Query("select c from Category c " +
              "where c.name like %?1% ")
       List<Category> filmbycategory(String name);
    
        
    /*
       @Query("select fc from FilmCategory fc " +
              "inner join Category c on c.categoryId = fc.category" +
              "inner join Film f on f.filmId = fc.film " +
              "where c.name like %?1% ")
       List<Category> filmbycategory(String name);
    */
}
