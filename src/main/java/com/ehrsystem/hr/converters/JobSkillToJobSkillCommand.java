package com.ehrsystem.hr.converters;

import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.model.JobSkill;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobSkillToJobSkillCommand implements Converter<JobSkill, JobSkillCommand> {

    @Synchronized
    @Nullable
    @Override
    public JobSkillCommand convert(JobSkill jobSkill) {
        if (jobSkill == null) {
            return null;
        }

        JobSkillCommand jobSkillCommand = new JobSkillCommand();
        jobSkillCommand.setId(jobSkill.getId());
        if (jobSkill.getJobPost() != null) {
            jobSkillCommand.setJobPostId(jobSkill.getJobPost().getId());
        }
        jobSkillCommand.setSkillName(jobSkill.getSkillName());
        jobSkillCommand.setSkillLevel(jobSkill.getSkillLevel());

        return jobSkillCommand;
    }
}
