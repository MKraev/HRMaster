package com.ehrsystem.hr.converters;


import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.JobSkill;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobSkillCommandToJobSkill implements Converter<JobSkillCommand, JobSkill> {



    @Nullable
    @Override
    public JobSkill convert(JobSkillCommand source) {
        if (source == null) {
            return null;
        }

        final JobSkill jobSkill = new JobSkill();
        jobSkill.setId(source.getId());

        if(source.getJobPostId() != null){
            JobPost jobPost = new JobPost();
            jobPost.setId(source.getJobPostId());
            jobSkill.setJobPost(jobPost);
            jobPost.addJobSkill(jobSkill);
        }

        jobSkill.setSkillName(source.getSkillName());
        jobSkill.setSkillLevel(source.getSkillLevel());
        return jobSkill;
    }
}
