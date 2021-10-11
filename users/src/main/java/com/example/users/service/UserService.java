package com.example.users.service;


import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    public List<User> getUsers() {
        return repository.getAll();
    }

    public List<User> getUsers(LinkedList<Long> usersId) {
        final List<User> users = new LinkedList<>();
        usersId.forEach(v-> users.add(repository.getById(v)));
        return users;
    }
}
