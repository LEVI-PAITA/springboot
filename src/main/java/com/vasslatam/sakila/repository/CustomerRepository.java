/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository;

import com.vasslatam.sakila.domain.Customer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USERVASSPERU
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    @Query(value = "SELECT get_customer_balance(?1,?2)", nativeQuery = true)
    BigDecimal getcustomer(int customerId, LocalDateTime date);
    
    @Query(value = "select c.first_name as 'name' , c.last_name, c.email, a.address, s.store_id from customer c inner join address a on a.address_id = c.address_id "
            + "inner join store s on s.store_id = c.store_id where "
            + "c.first_name like %?1% and a.address like %?2% and s.store_id = ?3",
            nativeQuery = true)
    public List<Object[]> findbycustomeraddress(String firstname, String address, Integer store);
}
