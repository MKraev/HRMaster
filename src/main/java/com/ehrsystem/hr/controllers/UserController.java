package com.ehrsystem.hr.controllers;




import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/registration")
    public String checkoutForm(Model model){

        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doCheckout(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User savedUser = userRepository.save(user);

        return "registrationcompleted";

    }
}
