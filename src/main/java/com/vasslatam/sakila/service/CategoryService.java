/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Category;
import java.util.List;

/**
 *
 * @author USERVASSPERU
 */
public interface CategoryService {
    
    List<Category> filmbycategory(String name);
}
