package com.example.data.controller;

import com.example.data.dto.ResponseDto;
import com.example.data.entity.Payment;
import com.example.data.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log
public class DataController {

    private final PaymentsService service;

    @Setter(onMethod_={@Value("${app.id}")})
    private String id;

    @GetMapping
    public ResponseDto endpoint(@RequestHeader Optional<String> authorization) {
        log.info("request");
        return new ResponseDto(id);
    }

    @GetMapping("/payments/{count}")
    List<Payment> getList(@PathVariable int count){
        return service.getList(count);
    }

}
