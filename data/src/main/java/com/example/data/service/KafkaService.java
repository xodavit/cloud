package com.example.data.service;

import com.example.data.entity.Payment;
import com.example.data.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Log
public class KafkaService {
    private final PaymentRepository repository;
    private final String TOPIC_PAYMENTS = "other.payments";
    private final String CONSUMER = "data.consumers";


    @KafkaListener(groupId = CONSUMER, topics = TOPIC_PAYMENTS)
    public void listen(Payment message, Acknowledgment acknowledgment) {
        log.info(String.valueOf(message));
        repository.save(message);
        acknowledgment.acknowledge();
    }

}
