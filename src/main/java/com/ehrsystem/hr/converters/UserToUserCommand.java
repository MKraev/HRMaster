package com.ehrsystem.hr.converters;


import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {

    private final UserSkillToUserSkillCommand userSkillConverter;

    public UserToUserCommand(UserSkillToUserSkillCommand userSkillConverter) {
        this.userSkillConverter = userSkillConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }

        final UserCommand command = new UserCommand();
        command.setUserId(source.getUserId());
        command.setUserName(source.getUsername());
        command.setPassword(source.getPassword());
        command.setFirstName(source.getFirstName());
        command.setLastName(source.getLastName());
        command.setJobTitle(source.getJobTitle());
        command.setSeniorityLevel(source.getSeniorityLevel());
        command.setStatus(source.getStatus());
        command.setEmailUser(source.getEmailUser());
        command.setUserType(source.getUserType());
        command.setResume(source.getResume());
        command.setCity(source.getCity());



        if (source.getUserSkills() != null && source.getUserSkills().size() > 0){
            source.getUserSkills()
                    .forEach(userSkill -> {
                        command.getUserSkills().add(userSkillConverter.convert(userSkill));
                    });
        }

        return command;
    }
}
