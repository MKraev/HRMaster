package com.ehrsystem.hr.controllers;

import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.JobSkill;
import com.ehrsystem.hr.services.JobPostService;
import com.ehrsystem.hr.services.JobSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class JobSkillController {

    private final JobSkillService jobSkillService;
    private final JobPostService jobPostService;

    public JobSkillController(JobSkillService jobSkillService, JobPostService jobPostService) {
        this.jobSkillService = jobSkillService;
        this.jobPostService = jobPostService;
    }



    @GetMapping("/job/{jobPostId}/jobskill")
    public String listJobSkill(@PathVariable String jobPostId, Model model){

        // use command object to avoid lazy load errors in Thymeleaf.
        model.addAttribute("jobPost", jobPostService.findCommandById(Long.valueOf(jobPostId)));

        return "job/jobskill/list";
    }


    @GetMapping("/job/{jobPostId}/jobskill/{id}/show")
    public String showJobSkill(@PathVariable String jobPostId,
                                       @PathVariable String id, Model model){
        model.addAttribute("jobSkill", jobSkillService.findByJobPostIdAndSkillId(Long.valueOf(jobPostId), Long.valueOf(id)));

        return "job/jobskill/show";
    }


    @GetMapping("/job/{jobPostId}/jobskill/new")
    public String newJobPost(@PathVariable String jobPostId, Model model){

        //make sure we have a good id value
        JobPostCommand jobPostCommand = jobPostService.findCommandById(Long.valueOf(jobPostId));
        //todo raise exception if null

        //need to return back parent id for hidden form property
        JobSkillCommand jobSkillCommand = new JobSkillCommand();
        jobSkillCommand.setJobPostId(Long.valueOf(jobPostId));
        model.addAttribute("jobSkill", jobSkillCommand);

        return "job/jobskill/jobskillform";
    }

    @GetMapping("/job/{jobPostId}/jobskill/{id}/update")
    public String updateJobPostSkill(@PathVariable String jobPostId,
                                         @PathVariable String id, Model model){
        model.addAttribute("jobSkill", jobSkillService.findByJobPostIdAndSkillId(Long.valueOf(jobPostId), Long.valueOf(id)));

        return "job/jobskill/jobskillform";
    }

    @PostMapping("job/{jobPostId}/jobskill")
    public String saveOrUpdate(@ModelAttribute JobSkillCommand command){
        JobSkillCommand savedCommand = jobSkillService.saveJobSkillCommand(command);

        log.debug("saved jobPost id:" + savedCommand.getJobPostId());
        log.debug("saved jobSkill id:" + savedCommand.getId());

        return "redirect:/job/" + savedCommand.getJobPostId() + "/jobskill/"+ savedCommand.getId() + "/show";
    }



    @GetMapping("job/{jobPostId}/jobskill/{id}/delete")
    public String deleteJobSkill(@PathVariable String jobPostId,
                                   @PathVariable String id){

        jobSkillService.deleteById(Long.valueOf(jobPostId), Long.valueOf(id));

        return "redirect:/job/" + jobPostId + "/jobskill";
    }
}
















