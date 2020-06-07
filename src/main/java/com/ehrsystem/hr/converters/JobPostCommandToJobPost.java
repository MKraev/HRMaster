package com.ehrsystem.hr.converters;

import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.model.JobPost;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobPostCommandToJobPost implements Converter<JobPostCommand, JobPost> {

    private final JobSkillCommandToJobSkill jobSkillCommandToJobSkill;

    public JobPostCommandToJobPost(JobSkillCommandToJobSkill jobSkillCommandToJobSkill) {
        this.jobSkillCommandToJobSkill = jobSkillCommandToJobSkill;
    }


    @Synchronized
    @Nullable
    @Override
    public JobPost convert(JobPostCommand source) {
        if (source == null) {
            return null;
        }

        final JobPost jobPost = new JobPost();
        jobPost.setId(source.getId());
        jobPost.setCity(source.getCity());
        jobPost.setDescription(source.getDescription());
        jobPost.setTitle(source.getTitle());
        jobPost.setRequirement(source.getRequirement());

        if (source.getJobSkills() != null && source.getJobSkills().size() > 0){
            source.getJobSkills()
                    .forEach( jobSkill -> jobPost.getJobSkills().add(jobSkillCommandToJobSkill.convert(jobSkill)));
        }


        return jobPost;
    }
}
