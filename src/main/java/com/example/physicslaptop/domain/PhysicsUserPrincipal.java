package com.example.physicslaptop.domain;

import com.example.physicslaptop.domain.User;

import java.nio.file.attribute.UserPrincipal;

public class PhysicsUserPrincipal implements UserPrincipal {

    private User user;

    public PhysicsUserPrincipal(User user){
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getEmail();
    }
}
