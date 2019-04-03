package com.example.physicslaptop.controller;

import com.example.physicslaptop.domain.CollatedUser;
import com.example.physicslaptop.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;

    }

    @RequestMapping(value = "/profile")
    public ModelAndView showProfile(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CollatedUser user = profileService.getProfile(email);
        return new ModelAndView("profile","collatedUser",user);
    }



}
