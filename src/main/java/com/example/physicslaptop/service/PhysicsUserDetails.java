package com.example.physicslaptop.service;

import com.example.physicslaptop.dao.HistoryRepository;
import com.example.physicslaptop.dao.UserRepository;
import com.example.physicslaptop.domain.LoginHistory;
import com.example.physicslaptop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
public class PhysicsUserDetails implements UserDetailsService {



    private UserRepository userRepository;


    private HistoryRepository historyRepository;


    @Autowired
    public PhysicsUserDetails(UserRepository userRepository, HistoryRepository historyRepository){
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("no matching user"));

        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(user.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(),user.getPassword(),user.getEnabled(),
                true,true,true,authorities);
    }



}
