package com.ehrsystem.hr.services;


import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.model.JobPost;

import java.util.Set;

public interface JobPostService {

    Set<JobPost> getJobPost();

    JobPost save(JobPost jobPost);

    JobPostCommand saveJobPostCommand(JobPostCommand command);

    JobPostCommand findCommandById(Long l);

    JobPost findById(Long l);

    void deleteById(Long idToDelete);
}
