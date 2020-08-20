package com.ehrsystem.hr.converters;


import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.model.UserSkill;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserSkillCommandToUserSkill implements Converter<UserSkillCommand, UserSkill> {



    @Nullable
    @Override
    public UserSkill convert(UserSkillCommand source) {
        if (source == null) {
            return null;
        }

        final UserSkill userSkill = new UserSkill();
        userSkill.setId(source.getUserSkillId());

        if(source.getThisUserId() != null){
            User user = new User();
            user.setUserId(source.getThisUserId());
            userSkill.setUser(user);
            user.addUserSkill(userSkill);
        }

        userSkill.setUserSkillName(source.getUserSkillName());
        userSkill.setUserSkillLevel(source.getUserSkillLevel());
        return userSkill;
    }

}
