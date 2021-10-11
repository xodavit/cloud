package com.example.consumer.service;

import com.example.consumer.data.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Log
public class KafkaService {
    private final String TOTOPIC = "other.payments";
    private final String TOPIC_PAYMENTS = "payments";
    private final String CONSUMER = "consumer";
    private final String KEY = "consumer.payment";
    private final KafkaTemplate<String, Payment> template;

    @KafkaListener(groupId = CONSUMER, topics = TOPIC_PAYMENTS)
    public void listen(Payment message, Acknowledgment acknowledgment) {
        log.info(String.valueOf(message));
        send(message);
        acknowledgment.acknowledge();
    }

    public void send(Payment payment) {
        final ListenableFuture<SendResult<String, Payment>> future = template.send(
                new ProducerRecord<>(TOTOPIC, KEY, payment));
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, Payment> result) {
                log.info(String.valueOf(result));
            }
        });
    }
}
