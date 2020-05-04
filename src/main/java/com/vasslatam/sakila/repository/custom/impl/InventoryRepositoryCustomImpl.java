/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository.custom.impl;

import com.vasslatam.sakila.domain.Inventory;
import com.vasslatam.sakila.repository.custom.InventoryRepositoryCustom;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USERVASSPERU
 */
public class InventoryRepositoryCustomImpl implements InventoryRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Inventory findByInventoryId(int inventoryId) {
        return em.find(Inventory.class, inventoryId);
    }

    @Override
    public Boolean inventoryInStock(int inventoryId) {
        Query query = em.createNativeQuery("SELECT inventory_in_stock(?)")
                .setParameter(1, inventoryId);
        Boolean result = (Boolean) query.getSingleResult();
        return result;
    }
    
}
