package com.ehrsystem.hr.converters;

import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.model.UserSkill;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserSkillToUserSkillCommand implements Converter<UserSkill, UserSkillCommand> {

    @Synchronized
    @Nullable
    @Override
    public UserSkillCommand convert(UserSkill userSkill) {
        if (userSkill == null) {
            return null;
        }

        UserSkillCommand userSkillCommand = new UserSkillCommand();
        userSkillCommand.setUserSkillId(userSkill.getId());
        if (userSkill.getUser() != null) {
            userSkillCommand.setThisUserId(userSkill.getUser().getUserId());
        }
        userSkillCommand.setUserSkillName(userSkill.getUserSkillName());
        userSkillCommand.setUserSkillLevel(userSkill.getUserSkillLevel());


        return userSkillCommand;
    }
}
