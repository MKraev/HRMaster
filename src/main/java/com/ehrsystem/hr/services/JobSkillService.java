package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.model.JobSkill;

public interface JobSkillService {

    JobSkillCommand saveJobSkillCommand(JobSkillCommand command);

    JobSkillCommand findByJobPostIdAndSkillId(Long jobPostId, Long jobSkillId);

    void deleteById(Long jobPostId, Long idToDelete);
}
