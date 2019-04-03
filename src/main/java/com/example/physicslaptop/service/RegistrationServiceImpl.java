package com.example.physicslaptop.service;


import com.example.physicslaptop.dao.UserRepository;
import com.example.physicslaptop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegistrationServiceImpl implements RegistrationService{

    private User currentUser;
    private UserRepository userRepository;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        userRepository.save(new User("mark","henry","mark@company.com","best"));
    }



    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        currentUser = user;
        userRepository.save(user);

    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public int getNumberOfUsers() {
        return (int) userRepository.count();
    }
}
