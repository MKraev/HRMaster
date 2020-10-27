package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.JobSkillCommand;
import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.converters.UserSkillCommandToUserSkill;
import com.ehrsystem.hr.converters.UserSkillToUserSkillCommand;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.model.UserSkill;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.repositories.UserSkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class UserSkillServiceImpl implements UserSkillService {

    private final UserSkillRepository userSkillRepository;
    private final UserRepository userRepository;
    private final UserSkillCommandToUserSkill userSkillCommandToUserSkill;
    private final UserSkillToUserSkillCommand userSkillToUserSkillCommand;

    public UserSkillServiceImpl(UserSkillRepository userSkillRepository, UserRepository userRepository,
                                UserSkillCommandToUserSkill userSkillCommandToUserSkill,
                                UserSkillToUserSkillCommand userSkillToUserSkillCommand) {
        this.userSkillRepository = userSkillRepository;
        this.userRepository = userRepository;
        this.userSkillCommandToUserSkill = userSkillCommandToUserSkill;
        this.userSkillToUserSkillCommand = userSkillToUserSkillCommand;
    }


    @Override
    public UserSkill save(UserSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    @Override
    public UserSkill findByUserIdAndSkillId(Long userSkillId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

        Optional<UserSkill> userSkill = user.getUserSkills().stream().
                filter(userSkill2 -> userSkill2.getId().equals(userSkillId))
                .findFirst();

        if(userSkill.isPresent()) {
            return userSkill.get();
        }else{
            return userSkillRepository.getOne(userSkillId);
        }
    }



    @Override
    public void deleteById(Long userId, Long idToDelete) {

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()) {
            User user = userOptional.get();

            Optional<UserSkill> userSkillOptional = user
                    .getUserSkills()
                    .stream()
                    .filter(userSkill -> userSkill.getId().equals(idToDelete))
                    .findFirst();

            if (userSkillOptional.isPresent()) {
                UserSkill userSkillToDelete = userSkillOptional.get();
                userSkillToDelete.setUser(null);
                user.getUserSkills().remove(userSkillOptional.get());
                userRepository.save(user);
            }
        }
    }

    @Override
    @Transactional
    public UserSkillCommand saveUserSkillCommand(UserSkillCommand command) {
        Optional<User> userOptional = userRepository.findById(command.getThisUserId());

        if (!userOptional.isPresent()) {

            return new UserSkillCommand();
        } else {
            User user = userOptional.get();

            Optional<UserSkill> userSkillOptional = user
                    .getUserSkills()
                    .stream()
                    .filter(userSkill -> userSkill.getId().equals(command.getUserSkillId()))
                    .findFirst();

            if (userSkillOptional.isPresent()) {
                UserSkill userSkillFound = userSkillOptional.get();
                userSkillFound.setUserSkillName(command.getUserSkillName());
                userSkillFound.setUserSkillLevel(command.getUserSkillLevel());
            } else {
                //add new Skill
                UserSkill userSkill = userSkillCommandToUserSkill.convert(command);
                userSkill.setUser(user);
                user.addUserSkill(userSkill);
            }

            User savedUser = userRepository.save(user);

            Optional<UserSkill> savedUserSkillOptional = savedUser.getUserSkills().stream()
                    .filter(userSkill -> userSkill.getId().equals(command.getUserSkillId()))
                    .findFirst();

            //check by description
            if (!savedUserSkillOptional.isPresent()) {
                savedUserSkillOptional = savedUser.getUserSkills().stream()
                        .filter(userSkill -> userSkill.getUserSkillName().equals(command.getUserSkillName()))
                        .findFirst();
            }

            //to do check for fail
            return userSkillToUserSkillCommand.convert(savedUserSkillOptional.get());
        }
    }
}














