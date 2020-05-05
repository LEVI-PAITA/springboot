/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Customer;
import com.vasslatam.sakila.endpoint.request.CustomerRequest;
import com.vasslatam.sakila.service.CustomerService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USERVASSPERU
 */
@RestController
@RequestMapping("/api")

public class CustomerEndpoint {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customer")
    public List<Customer> index(){
        return customerService.findAll();
    }
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id){
        
        Customer customer = null;
        
        Map<String, Object> response = new HashMap<>();
        
        try{
            customer = customerService.findById(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(customer == null){
            response.put("mensaje", "El customer ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    
    @PostMapping(path = "/customer",consumes = "application/json" ,produces = "application/json")
    public ResponseEntity<?> create(@RequestBody CustomerRequest request){
        Customer customer = customerService.create(request.getStore(), request.getFirstName(),
                request.getLastName(), request.getEmail(), request.getAddress());
        return ResponseEntity.ok(customer);
    }
    
    /*
    @PostMapping("/customer")
    public Customer create(@RequestBody Customer request){
        Customer customer = customerService.create(request.getStore(), request.getFirstName(),
                request.getLastName(), request.getEmail(), request.getAddress());
        return customer;
    }
    */
    /*
    @PostMapping("/customer")
    public ResponseEntity<?> create(@RequestBody Customer customer){
        
        Customer customernew = null;
        Map<String, Object> response = new HashMap<>();
         
        try{
            customernew = customerService.save(customer);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con éxito!");
        response.put("cliente", customernew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    */
    
    @PutMapping("/customer/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable Integer id){
        
        Customer customeractual = customerService.findById(id);
        
        Customer customerUpdated = null;
        customeractual.setFirstName(customer.getFirstName());
        customeractual.setLastName(customer.getLastName());
        customeractual.setEmail(customer.getEmail());
        customeractual.setAddress(customer.getAddress());
        customeractual.setStore(customer.getStore());
        
        customerUpdated = customerService.save(customeractual);
        return customerUpdated;
    }
    
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        customerService.delete(id);
        return ResponseEntity.ok(id);
    }
    
    @GetMapping("/by-customer")
    public List<Object[]> findByCustomerAddress(@RequestParam("customer") String customer,
                                                @RequestParam("address") String address,
                                                @RequestParam("store") Integer store)
    {
        List<Object[]> customeraddress = customerService.findbycustomeraddress(customer, address,store);
        return customeraddress;
    }
}
