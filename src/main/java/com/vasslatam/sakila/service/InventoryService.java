/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service;

import com.vasslatam.sakila.domain.Inventory;

/**
 *
 * @author USERVASSPERU
 */
public interface InventoryService {
    
    Inventory findByInventoryId(int inventoryId);
    
    Boolean inventoryInStock(int inventoryId);
}
