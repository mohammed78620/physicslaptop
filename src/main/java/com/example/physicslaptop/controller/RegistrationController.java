package com.example.physicslaptop.controller;

import com.example.physicslaptop.domain.User;
import com.example.physicslaptop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;

    }




    @RequestMapping(value = "/register" ,method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(){
        return new ModelAndView("register","user",new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistrationForm(User user){
        registrationService.addUser(user);
        return "redirect:/profile";
    }
//    @RequestMapping(value = "/profile")
//    public ModelAndView showProfile(){
//        return  new ModelAndView("/profile","users",registrationService.getCurrentUser());
//    }
    @RequestMapping(value = "/users")
    public ModelAndView showUser(){
        return new ModelAndView("/users","users",registrationService.getUsers());
    }


    @RequestMapping(value = "/mass")
    public ModelAndView showMass(){
        return new ModelAndView("/mass");
    }

}