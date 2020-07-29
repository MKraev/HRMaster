package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.commands.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by jt on 2/2/16.
 */
@Controller
public class LoginController {

    @RequestMapping({"/login","/loginform"})
    public String showLoginForm(Model model){

        model.addAttribute("loginCommand", new LoginCommand());

        return "user/loginform";
    }

    @RequestMapping("logout-success")
    public String yourLoggedOut(){

        return "logout-success";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "user/loginform";
        }

        return "redirect:index";
    }
}
