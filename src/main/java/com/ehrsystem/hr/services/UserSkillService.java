package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.model.User;

public interface UserSkillService {

    UserSkillCommand saveUserSkillCommand(UserSkillCommand command);

    UserSkillCommand findByUserIdAndSkillId(Long userId, Long userSkillId);

    void deleteById(Long userId, Long idToDelete);
}
