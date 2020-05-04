/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.repository;

import com.vasslatam.sakila.domain.Customer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
}
