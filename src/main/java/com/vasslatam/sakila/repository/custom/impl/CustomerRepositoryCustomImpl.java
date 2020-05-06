/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository.custom.impl;

import com.vasslatam.sakila.domain.Address;
import com.vasslatam.sakila.domain.Address_;
import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.domain.Customer_;
import com.vasslatam.sakila.domain.Store;
import com.vasslatam.sakila.domain.Store_;
import com.vasslatam.sakila.repository.custom.CustomerRepositoryCustom;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author USERVASSPERU
 */
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
            
    @Override
    public List<Customer> findbycustomeraddress(String firstname, String address, Integer store) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customer = cq.from(Customer.class);
        Join<Customer, Store> s = customer.join(Customer_.store);
        Join<Customer, Address> a = customer.join(Customer_.address);
        
        String firstnameWilcard = '%' + firstname.replace(' ', '%') + '%';
        String addressWilcard = '%' + address.replace(' ', '%') + '%';
        
        cq.select(customer)
                .where(
                  cb.like(customer.get(Customer_.firstName), firstnameWilcard),
                  cb.and(cb.like(a.get(Address_.address1), addressWilcard)),
                  cb.and(cb.equal(s.get(Store_.storeId), store))
                );
        TypedQuery<Customer> query = em.createQuery(cq);
        return query.getResultList();
    }
    
}
