package com.ehrsystem.hr.services;


import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.converters.JobPostCommandToJobPost;
import com.ehrsystem.hr.converters.JobPostToJobPostCommand;
import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class JobPostServiceImpl implements JobPostService {

    private final JobPostRepository jobPostRepository;
    private final JobPostToJobPostCommand jobPostToJobPostCommand;
    private final JobPostCommandToJobPost jobPostCommandToJobPost;
    private final UserRepository userRepository;

    public JobPostServiceImpl(JobPostRepository jobPostRepository, JobPostToJobPostCommand jobPostToJobPostCommand, JobPostCommandToJobPost jobPostCommandToJobPost, UserRepository userRepository) {
        this.jobPostRepository = jobPostRepository;
        this.jobPostToJobPostCommand = jobPostToJobPostCommand;
        this.jobPostCommandToJobPost = jobPostCommandToJobPost;
        this.userRepository = userRepository;
    }

    @Override
    public Set<JobPost> getJobPost() {
        Set<JobPost> jobPostSet = new HashSet<>();
        jobPostRepository.findAll().iterator().forEachRemaining(jobPostSet::add);
        return jobPostSet;
    }

    @Override
    public Set<JobPost> getJobPostByUser(User user) {
        Set<JobPost> jobPostSet = user.getJobPosted();
        return jobPostSet;
    }

    @Override
    public Set<JobPost> getJobApplyedByUser(User user) {
        Set<JobPost> jobPostSet = user.getJobApplied();
        return jobPostSet;
    }

    @Override
    public JobPost save(JobPost jobPost) {

        JobPost savedJobs = jobPostRepository.save(jobPost);
        return savedJobs;
    }

    @Override
    public JobPostCommand saveJobPostCommand(JobPostCommand command) {
        JobPost detachedJobPost = jobPostCommandToJobPost.convert(command);

        JobPost savedJobPost = jobPostRepository.save(detachedJobPost);

        return jobPostToJobPostCommand.convert(savedJobPost);
    }

    @Override
    public JobPost findById(Long l) {

        Optional<JobPost> jobPostOptional = jobPostRepository.findById(l);

        return jobPostOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        jobPostRepository.deleteById(idToDelete);
    }



    @Override
    @Transactional
    public JobPostCommand findCommandById(Long l) {
        return jobPostToJobPostCommand.convert(findById(l));
    }
}