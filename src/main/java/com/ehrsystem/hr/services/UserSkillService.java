package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.model.UserSkill;

public interface UserSkillService {

    UserSkill save(UserSkill userSkill);

    UserSkill findByUserIdAndSkillId(Long userSkillId);

    void deleteById(Long userId, Long idToDelete);

    UserSkillCommand saveUserSkillCommand(UserSkillCommand command);
}
