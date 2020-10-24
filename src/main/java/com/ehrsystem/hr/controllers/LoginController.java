package com.ehrsystem.hr.controllers;



import com.ehrsystem.hr.commands.UserCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Slf4j
@Controller
public class LoginController {

    @RequestMapping({"/login","/loginform"})
    public String showLoginForm(Model model){

        model.addAttribute("userCommand", new UserCommand());

        return "user/loginform";
    }

    @RequestMapping("logout-success")
    public String yourLoggedOut(){

        return "logout-success";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid UserCommand userCommand, BindingResult bindingResult){

        log.debug("Loggin Controller");

        if(bindingResult.hasErrors()){
            return "user/loginform";
        }

        return "index";
    }
}
