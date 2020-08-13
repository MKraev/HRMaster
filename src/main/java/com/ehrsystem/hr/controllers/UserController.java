package com.ehrsystem.hr.controllers;




import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @RequestMapping("/registration")
    public String checkoutForm(Model model){

        model.addAttribute("user", new User());

        return "user/registration";
    }

    @GetMapping("/user/{id}/showuser")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("user", userService.findById(new Long(id)));

        return "user/showuser";
    }


    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doCheckout(@Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        User savedUser = userRepository.save(user);

        return "user/registrationcompleted";

    }
}
