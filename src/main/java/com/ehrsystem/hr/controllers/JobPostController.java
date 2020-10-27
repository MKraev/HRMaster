package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.services.JobPostService;
import com.ehrsystem.hr.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class JobPostController {

    private final JobPostService jobPostService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public JobPostController(JobPostService jobPostService, UserService userService, UserRepository userRepository, JobPostRepository jobPostRepository) {
        this.jobPostService = jobPostService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.jobPostRepository = jobPostRepository;
    }

    @RequestMapping("/jobpost")
    public String saveJobPost(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);
        JobPost jobPost = new JobPost();
        jobPost.setPoster(user);

        user.getJobPosted().add(jobPost);

        jobPostService.save(jobPost);
        userService.save(user);
        model.addAttribute("jobPost", jobPost);
        return "job/jobpostform";
    }

    @PostMapping("/jobpost")
    public String saveOrUpdate(@Valid @ModelAttribute("jobPost") JobPost jobPost, BindingResult bindingResult){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

            if(bindingResult.hasErrors()){
                return "job/jobpostform";
            }
        jobPost.setPoster(user);
        JobPost saveJobPost = jobPostService.save(jobPost);

        return "redirect:/";
    }

    @GetMapping("/job/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("jobPost", jobPostService.findById(new Long(id)));
        return "job/show";
    }

    @GetMapping("/job/{id}/delete")
    public String deleteById(@PathVariable String id){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        JobPost jobPost = jobPostService.findById(Long.valueOf(id));
        if (Objects.equals(username, jobPost.getPoster().getUsername())) {
            User user= userRepository.findByUsername(username);
            user.getJobPosted().remove(jobPost);
            userService.save(user);
            jobPostRepository.deleteById(Long.valueOf(id));
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/job/{id}/update")
    public String updateJobPost(@PathVariable String id, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        JobPost jobPost = jobPostService.findById(Long.valueOf(id));

        if (Objects.equals(username, jobPost.getPoster().getUsername())) {
            model.addAttribute("jobPost", jobPostService.findCommandById(Long.valueOf(id)));
            return "job/jobpostform";
        }
        return "redirect:/";
    }

    @GetMapping("/job/{id}/apply")
    public String applyJobPost(@PathVariable String id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        JobPost jobPost = jobPostService.findById(Long.valueOf(id));
        User user= userRepository.findByUsername(username);

        if (Objects.equals(username, jobPost.getPoster().getUsername())) {
            return "job/show";
        }
        else{

            user.getJobApplied().add(jobPost);
            jobPost.getUsersApplied().add(user);

            JobPost saveJobPost = jobPostService.save(jobPost);
            User saveUser = userService.save(user);

            return "job/applycompleted";
        }
    }
}
