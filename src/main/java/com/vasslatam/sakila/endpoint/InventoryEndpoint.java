/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.service.InventoryService;
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
public class InventoryEndpoint {
    @Autowired
    private InventoryService inventoryService;
    
    @GetMapping("in-stock")
    public Boolean inStock (@RequestParam("inventoryId") int inventoryId){
        boolean stock = inventoryService.inventoryInStock(inventoryId);
        return stock;
    }
}
