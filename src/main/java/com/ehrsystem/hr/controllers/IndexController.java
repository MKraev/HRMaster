package com.ehrsystem.hr.controllers;

import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.services.JobPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */

@Controller
public class IndexController {

    private final UserRepository userRepository;
    private final JobPostService jobPostService;

    public IndexController(UserRepository userRepository, JobPostService jobPostService) {
        this.userRepository = userRepository;
        this.jobPostService = jobPostService;
    }


    @RequestMapping({"/login","/loginform"})
    public String getIndexPageLogin(Model model) {

        model.addAttribute("user", new User());

        return "loginform";
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("jobPosts", jobPostService.getJobPost());

        return "index";
    }

}
