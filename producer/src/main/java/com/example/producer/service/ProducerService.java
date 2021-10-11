package com.example.producer.service;

import com.example.producer.data.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Log
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, Payment> template;

    public Payment send(Payment payment) {
        final ListenableFuture<SendResult<String, Payment>> future = template.send(
                new ProducerRecord<>("payments", "ibank", payment));
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
        return payment;
    }
}
