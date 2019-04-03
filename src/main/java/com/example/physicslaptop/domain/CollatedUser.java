package com.example.physicslaptop.domain;


import java.util.List;

public class CollatedUser {

    private User user;
    private List<LoginHistory> logins;

    public  User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }
}
