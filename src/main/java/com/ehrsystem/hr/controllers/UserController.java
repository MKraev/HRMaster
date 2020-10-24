package com.ehrsystem.hr.controllers;



import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/registration")
    public String registrationForm(Model model){

        model.addAttribute("user", new User());

        return "user/registration";
    }

    @GetMapping("/user")
    public String showById(Model model){

       String username = SecurityContextHolder.getContext().getAuthentication().getName();
       log.info(username);
        User user= userRepository.findByUsername(username);

       model.addAttribute("user",user);

        return "user/showuser";
    }


    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doRegister(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        User savedUser = userRepository.save(user);

        return "user/registrationcompleted";

    }
}
