package com.ehrsystem.hr.converters;


import com.ehrsystem.hr.commands.JobPostCommand;
import com.ehrsystem.hr.model.JobPost;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobPostToJobPostCommand implements Converter<JobPost, JobPostCommand> {

    private final JobSkillToJobSkillCommand jobSkillConverter;

    public JobPostToJobPostCommand(JobSkillToJobSkillCommand jobSkillConverter) {
        this.jobSkillConverter = jobSkillConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public JobPostCommand convert(JobPost source) {
        if (source == null) {
            return null;
        }

        final JobPostCommand command = new JobPostCommand();
        command.setId(source.getId());
        command.setTitle(source.getTitle());
        command.setDescription(source.getDescription());
        command.setRequirement(source.getRequirement());
        command.setCity(source.getCity());
        command.setPoster(source.getPoster());
        command.setUsersApplied(source.getUsersApplied());


        if (source.getJobSkills() != null && source.getJobSkills().size() > 0){
            source.getJobSkills()
                    .forEach(jobSkill -> command.getJobSkills().add(jobSkillConverter.convert(jobSkill)));
        }

        return command;
    }
}
