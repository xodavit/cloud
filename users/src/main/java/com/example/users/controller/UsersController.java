package com.example.users.controller;

import com.example.users.entity.User;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log
public class UsersController {
    private final UserService service;

    @GetMapping("/users")
    public List<User> endpoint(@RequestHeader Optional<String> authorization) {
        log.info("request");
        // Return all users
        return service.getUsers();
    }

    @PostMapping("/users/list")
    public List<User> endpoint(@RequestBody LinkedList<Long> usersId) {
        log.info("users list request");
        // Return users by id collection
        return service.getUsers(usersId);
    }
}
