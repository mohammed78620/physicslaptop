package com.example.physicslaptop.service;

import com.example.physicslaptop.domain.User;

import java.util.List;

public interface RegistrationService {
    List<User> getUsers();
    void addUser(User user);
    User getCurrentUser();
    int getNumberOfUsers();
}
