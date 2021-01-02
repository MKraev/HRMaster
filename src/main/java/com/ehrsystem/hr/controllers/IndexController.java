package com.ehrsystem.hr.controllers;


import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.services.JobPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class IndexController {

    private final UserRepository userRepository;
    private final JobPostService jobPostService;
    private final JobPostRepository jobPostRepository;

    public IndexController(UserRepository userRepository, JobPostService jobPostService, JobPostRepository jobPostRepository) {
        this.userRepository = userRepository;
        this.jobPostService = jobPostService;
        this.jobPostRepository = jobPostRepository;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("jobPosts", jobPostService.getJobPost());

        return "index";
    }

    @RequestMapping("/search")
    public String searchIndexPage(Model model, String keyword) {

        if(keyword != null){
            model.addAttribute("jobPosts",jobPostRepository.findByKeyword(keyword));
            log.info(keyword);
            log.info(jobPostRepository.findByKeyword(keyword).toString());
        }else {
            model.addAttribute("jobPosts", jobPostService.getJobPost());
        }
        return "index";
    }

    @RequestMapping("/myjobs")
    public String getMyJobs(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

        model.addAttribute("jobsPosted", jobPostService.getJobPostByUser(user));
        model.addAttribute("jobsApplyed", jobPostService.getJobApplyedByUser(user));

        return "job/myjobs";
    }

}
