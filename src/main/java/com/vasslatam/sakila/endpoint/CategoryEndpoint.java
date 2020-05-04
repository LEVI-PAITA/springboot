/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Category;
import com.vasslatam.sakila.service.CategoryService;
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
public class CategoryEndpoint {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/by-category")
    public List<Category> filmbycategory(@RequestParam("name") String name){
        List<Category> categories = categoryService.filmbycategory(name);
        return categories;
    }
}
