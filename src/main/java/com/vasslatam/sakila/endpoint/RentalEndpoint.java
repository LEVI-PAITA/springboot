/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.domain.Inventory;
import com.vasslatam.sakila.domain.Payment;
import com.vasslatam.sakila.domain.Rental;
import com.vasslatam.sakila.domain.Staff;
import com.vasslatam.sakila.service.CustomerService;
import com.vasslatam.sakila.service.InventoryService;
import com.vasslatam.sakila.service.PaymentService;
import com.vasslatam.sakila.service.RentalService;
import com.vasslatam.sakila.service.StaffService;
import java.time.LocalDateTime;
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
public class RentalEndpoint {
    
    @Autowired 
    private RentalService rentalService;
    
    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private StaffService staffService;
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/rental-film")
    public String RentalFilm(@RequestParam("inventoryId") int inventoryId,
                             @RequestParam("customerId") int customerId,
                             @RequestParam("staffId") int staffId){
        Rental rental = new Rental();
        Inventory inventory = inventoryService.findByInventoryId(inventoryId);
        Staff staff = staffService.findByStaffId(staffId);
        Payment payment = new Payment();
        Customer customer = customerService.findbycustomerId(customerId);
        
        if(inventoryService.inventoryInStock(inventoryId)){
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rental.setReturnDate(LocalDateTime.now());
            rental.setLastDate(LocalDateTime.now());
            rentalService.create(rental);
            Rental lastRental = rentalService.findById(rentalService.lastInsert());
            payment.setAmount(customerService.getcustomer(customerId, LocalDateTime.now()));
            payment.setStaff(staff);
            payment.setRental(lastRental);
            payment.setCustomer(customer);
            payment.setLastUpdate(LocalDateTime.now());
            paymentService.createPayment(payment);
            return "ok";
        }else{
            return "Sin stock";
        }
        
    }
}
