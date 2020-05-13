/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.endpoint;

import com.vasslatam.sakila.domain.Country;
import com.vasslatam.sakila.service.CountryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USERVASSPERU
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CountryEndpoint {
    
    @Autowired
    private CountryService countryService;
        
    @GetMapping("/countrys")
    public List<Country> index(){
        return countryService.findAll();
    }
    
    @GetMapping("/country/page/{page}")
    public Page<Country> index(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page,4);
        return countryService.findAll(pageable);
    }
    
    @GetMapping("/country/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Country show(@PathVariable Integer id){
        return countryService.findById(id);
    }
    
    @PostMapping("/country")
    public ResponseEntity<?> create(@RequestBody Country country){
        Country countrynew = null;
        Map<String, Object> response = new HashMap<>();
        
        try{
            countrynew = countryService.save(country);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El pais ha sido creado con éxito!");
        response.put("country", countrynew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/country/{id}")
    public ResponseEntity<?> update(@RequestBody Country country, @PathVariable Integer id){
        Country countryactual = countryService.findById(id);
        
        Country countryUpdated = null;
        Map<String, Object> response = new HashMap<>();
        
        if(countryactual == null){
            response.put("mensaje", "Error: no se puede editar, el pais ID: ".concat(id.toString().concat("no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            countryactual.setCountry(country.getCountry());
            countryUpdated = countryService.save(countryactual);
         }catch(DataAccessException e){
            response.put("mensaje", "Error al actualizar el pais en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El pais ha sido actualizado con éxito!");
        response.put("country", countryUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/country/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            countryService.delete(id);
        }catch(DataAccessException e){
            response.put("mensaje", "Error al eliminar el pais de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El pais ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
