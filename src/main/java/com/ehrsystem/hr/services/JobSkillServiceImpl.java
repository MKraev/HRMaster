package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.converters.JobSkillCommandToJobSkill;
import com.ehrsystem.hr.converters.JobSkillToJobSkillCommand;
import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.JobSkill;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.JobSkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class JobSkillServiceImpl implements JobSkillService {

    private final JobSkillRepository jobSkillRepository;
    private final JobPostRepository jobPostRepository;
    private final JobSkillCommandToJobSkill jobSkillCommandToJobSkill;
    private final JobSkillToJobSkillCommand jobSkillToJobSkillCommand;

    public JobSkillServiceImpl(JobSkillRepository jobSkillRepository, JobPostRepository jobPostRepository,
                               JobSkillCommandToJobSkill jobSkillCommandToJobSkill, JobSkillToJobSkillCommand jobSkillToJobSkillCommand) {
        this.jobSkillRepository = jobSkillRepository;
        this.jobPostRepository = jobPostRepository;
        this.jobSkillCommandToJobSkill = jobSkillCommandToJobSkill;
        this.jobSkillToJobSkillCommand = jobSkillToJobSkillCommand;
    }


    @Override
    public JobSkillCommand findByJobPostIdAndSkillId(Long jobPostId, Long jobSkillId) {
        Optional<JobPost> jobPostOptional = jobPostRepository.findById(jobPostId);

        JobPost jobPost = jobPostOptional.get();

        Optional<JobSkillCommand> jobSkillCommandOptional = jobPost.getJobSkills().stream()
                .filter(jobSkill -> jobSkill.getId().equals(jobSkillId))
                .map( jobSkill -> jobSkillToJobSkillCommand.convert(jobSkill)).findFirst();


        return jobSkillCommandOptional.get();
    }


    @Override
    @Transactional
    public JobSkillCommand saveJobSkillCommand(JobSkillCommand command) {
        Optional<JobPost> jobPostOptional = jobPostRepository.findById(command.getJobPostId());

        if (!jobPostOptional.isPresent()) {
            log.error("Recipe not found for id: " + command.getJobPostId());
            return new JobSkillCommand();
        } else {
            JobPost jobPost = jobPostOptional.get();

            Optional<JobSkill> jobSkillOptional = jobPost
                    .getJobSkills()
                    .stream()
                    .filter(jobSkill -> jobSkill.getId().equals(command.getId()))
                    .findFirst();

            if (jobSkillOptional.isPresent()) {
                JobSkill jobSkillFound = jobSkillOptional.get();
                jobSkillFound.setSkillName(command.getSkillName());
                jobSkillFound.setSkillLevel(command.getSkillLevel());
            } else {
                //add new Skill
                JobSkill jobSkill = jobSkillCommandToJobSkill.convert(command);
                jobSkill.setJobPost(jobPost);
                jobPost.addJobSkill(jobSkill);
            }

            JobPost savedJobPost = jobPostRepository.save(jobPost);

            Optional<JobSkill> savedJobSkillOptional = savedJobPost.getJobSkills().stream()
                    .filter(jobPostSkill -> jobPostSkill.getId().equals(command.getId()))
                    .findFirst();

            //check by description
            if (!savedJobSkillOptional.isPresent()) {
                savedJobSkillOptional = savedJobPost.getJobSkills().stream()
                        .filter(jobPostSkill -> jobPostSkill.getSkillName().equals(command.getSkillName()))
                        .findFirst();
            }

            //to do check for fail
            return jobSkillToJobSkillCommand.convert(savedJobSkillOptional.get());
        }
    }

    @Override
    public void deleteById(Long jobPostId, Long idToDelete) {

        Optional<JobPost> jobPostOptional = jobPostRepository.findById(jobPostId);

        if(jobPostOptional.isPresent()) {
            JobPost jobPost = jobPostOptional.get();

            Optional<JobSkill> jobSkillOptional = jobPost
                    .getJobSkills()
                    .stream()
                    .filter(jobSkill -> jobSkill.getId().equals(idToDelete))
                    .findFirst();

            if (jobSkillOptional.isPresent()) {
                JobSkill jobSkillToDelete = jobSkillOptional.get();
                jobSkillToDelete.setJobPost(null);
                jobPost.getJobSkills().remove(jobSkillOptional.get());
                jobPostRepository.save(jobPost);
            }
        }
    }
}














