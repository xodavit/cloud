package com.example.data.service;

import com.example.data.entity.Payment;
import com.example.data.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class KafkaService {
    private final PaymentRepository repository;

    @KafkaListener(groupId = "data.consumers", topics = "other.payments")
    public void listen(Payment message) {
        log.info(String.valueOf(message));
//        acknowledgment.acknowledge();
        repository.save(message);
    }
}
