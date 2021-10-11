package com.example.producer.controller;

import com.example.producer.data.Payment;
import com.example.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService service;

    @PostMapping("/payments")
    public Payment send(@RequestBody Payment payment) {
        return service.send(payment);
    }
}
