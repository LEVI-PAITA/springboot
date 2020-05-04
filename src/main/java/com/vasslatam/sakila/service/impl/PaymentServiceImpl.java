/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.service.impl;

import com.vasslatam.sakila.domain.Payment;
import com.vasslatam.sakila.repository.PaymentRepository;
import com.vasslatam.sakila.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USERVASSPERU
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;
            
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    
}
