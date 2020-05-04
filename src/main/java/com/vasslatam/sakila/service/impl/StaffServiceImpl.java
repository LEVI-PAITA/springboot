/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Staff;
import com.vasslatam.sakila.repository.StaffRepository;
import com.vasslatam.sakila.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;
            
    @Override
    public Staff findByStaffId(int staffId) {
        return staffRepository.getOne(staffId);
    }
    
}
