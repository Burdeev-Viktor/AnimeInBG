package com.example.AnimeInBG.controller;

import com.example.AnimeInBG.model.User;
import com.example.AnimeInBG.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/add-user",method = RequestMethod.GET)
    public String getRegistrationForm(Model model){
        model.addAttribute("newUser",new User());
        return "RegForm";
    }
    @RequestMapping(value = "/add-user",method = RequestMethod.POST)
    public String registrationUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }
}
