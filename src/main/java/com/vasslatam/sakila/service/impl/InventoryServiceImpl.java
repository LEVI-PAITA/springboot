/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Inventory;
import com.vasslatam.sakila.repository.InventoryRepository;
import com.vasslatam.sakila.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class InventoryServiceImpl implements InventoryService{
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Override
    public Inventory findByInventoryId(int inventoryId) {
        return inventoryRepository.findByInventoryId(inventoryId);
    }

    @Override
    public Boolean inventoryInStock(int inventoryId) {
        return inventoryRepository.inventoryInStock(inventoryId);
    }
    
}
