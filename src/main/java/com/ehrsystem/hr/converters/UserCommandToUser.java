package com.ehrsystem.hr.converters;

import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    private final UserSkillCommandToUserSkill userSkillCommandToUserSkill;

    public UserCommandToUser(UserSkillCommandToUserSkill userSkillCommandToUserSkill) {
        this.userSkillCommandToUserSkill = userSkillCommandToUserSkill;
    }


    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand source) {
        if (source == null) {
            return null;
        }

        final User user = new User();
        user.setUserId(source.getUserID());
        user.setUsername(source.getUserName());
        user.setPassword(source.getPassword());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setJobTitle(source.getJobTitle());
        user.setSeniorityLevel(source.getSeniorityLevel());
        user.setStatus(source.getStatus());
        user.setEmailUser(source.getEmailUser());
        user.setUserType(source.getUserType());
        user.setResume(source.getResume());
        user.setCity(source.getCity());

        if (source.getUserSkills() != null && source.getUserSkills().size() > 0){
            source.getUserSkills()
                    .forEach(userSkill -> user.getUserSkills().add(userSkillCommandToUserSkill.convert(userSkill)));
        }


        return user;
    }
}
