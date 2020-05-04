/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Category;
import com.vasslatam.sakila.repository.CategoryRepository;
import com.vasslatam.sakila.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;
            
    @Override
    public List<Category> filmbycategory(String name) {
        return categoryRepository.filmbycategory(name);
    }
    
}
