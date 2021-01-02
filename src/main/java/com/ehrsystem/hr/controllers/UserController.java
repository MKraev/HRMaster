package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserController(UserRepository userRepository, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @RequestMapping("/registration")
    public String registrationForm(Model model){

        model.addAttribute("user", new User());

        return "user/registration";
    }

    @RequestMapping("/adduserinfo")
    public String updateUserInfo(Model model){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        model.addAttribute("user", user);

        return "user/adduserinfo";
    }

    @GetMapping("/user")
    public String showById(Model model){

       String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

       model.addAttribute("user",user);

        return "user/showuser";
    }


    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doRegister(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        User savedUser = userRepository.save(user);

        return "user/registrationcompleted";

    }

    @RequestMapping(value = "/doupdateinfo", method = RequestMethod.POST)
    public String doUpdate(@ModelAttribute User updateUser){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User userLogged= userRepository.findByUsername(username);

            User updatedUser = userService.update(updateUser, userLogged);
            User savedUser = userService.save(updatedUser);


            return "user/showuser";
    }

    @GetMapping("/user/{userApplyedId}/viewuserapplyed")
    public String updateUserSkill(@PathVariable String userApplyedId, Model model){

        User user = userService.findById(Long.valueOf(userApplyedId));

        model.addAttribute("user", user);

        return "user/applyeduser";
    }
}
