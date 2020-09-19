package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.services.JobPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @RequestMapping("/jobpost")
    public String saveJobPost(Model model){
        model.addAttribute("jobPost", new JobPost());
        return "job/jobpostform";
    }

    @PostMapping("/jobpost")
    public String saveOrUpdate(@Valid @ModelAttribute("jobPost") JobPostCommand command, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "job/jobpostform";
        }
        JobPostCommand savedCommand = jobPostService.saveJobPostCommand(command);
        return "redirect:/";
    }

    @GetMapping("/job/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("jobPost", jobPostService.findById(new Long(id)));
        return "job/show";
    }

    @GetMapping("/job/{id}/delete")
    public String deleteById(@PathVariable String id){
        jobPostService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @GetMapping("/job/{id}/update")
    public String updateJobPost(@PathVariable String id, Model model){
        model.addAttribute("jobPost", jobPostService.findCommandById(Long.valueOf(id)));
        return "job/jobpostform";
    }
}
