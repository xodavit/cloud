package com.example.data.service;

import com.example.data.entity.Payment;
import com.example.data.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentsService {
    private final PaymentRepository repository;

    public List<Payment> getList(int count){
        return repository.getPaymentsList(count);
    }
}
