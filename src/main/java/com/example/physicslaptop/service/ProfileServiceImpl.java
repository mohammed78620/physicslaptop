package com.example.physicslaptop.service;

import com.example.physicslaptop.dao.HistoryRepository;
import com.example.physicslaptop.dao.UserRepository;
import com.example.physicslaptop.domain.CollatedUser;
import com.example.physicslaptop.domain.LoginHistory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    private UserRepository userRepository;
    private HistoryRepository historyRepository;

    public ProfileServiceImpl(UserRepository userRepository,HistoryRepository historyRepository){
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }


    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser user = new CollatedUser();
        user.setUser(userRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("no matching user found")));
        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setLogins(history);

        return user;
    }
}
