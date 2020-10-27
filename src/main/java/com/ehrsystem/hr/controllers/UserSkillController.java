package com.ehrsystem.hr.controllers;

import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.converters.UserSkillCommandToUserSkill;
import com.ehrsystem.hr.converters.UserSkillToUserSkillCommand;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.model.UserSkill;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.repositories.UserSkillRepository;
import com.ehrsystem.hr.services.UserService;
import com.ehrsystem.hr.services.UserSkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserSkillController {

    private final UserSkillService userSkillService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserSkillCommandToUserSkill commandToUserSkill;
    private final UserSkillToUserSkillCommand userSkillToUserSkillCommand;
    private final UserSkillRepository userSkillRepository;

    public UserSkillController(UserSkillService userSkillService, UserService userService, UserRepository userRepository, UserSkillCommandToUserSkill commandToUserSkill, UserSkillToUserSkillCommand userSkillToUserSkillCommand, UserSkillRepository userSkillRepository) {
        this.userSkillService = userSkillService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.commandToUserSkill = commandToUserSkill;
        this.userSkillToUserSkillCommand = userSkillToUserSkillCommand;
        this.userSkillRepository = userSkillRepository;
    }

    @GetMapping("/user/userskill")
    public String listUserSkill( Model model){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

        model.addAttribute("user", user);

        return "user/userskill/list";
    }



    @GetMapping("/user/userskill/new")
    public String newUserSkill( Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

        UserSkillCommand userSkillCommand = new UserSkillCommand();

        model.addAttribute("userSkill", userSkillCommand);

        return "user/userskill/userskillform";
    }


    @PostMapping("user/userskill/new")
    public String saveOrUpdate(@ModelAttribute UserSkillCommand command){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);
        command.setThisUserId(user.getUserId());
        UserSkill savedCommand = userSkillService.save(commandToUserSkill.convert(command));

        user.getUserSkills().add(savedCommand);
        userService.save(user);

        return "redirect:/user/" + user.getUserId() + "/userskill/"+ savedCommand.getId() + "/show";
    }


    @GetMapping("/user/{userId}/userskill/{id}/show")
    public String showUserSkill(@PathVariable String id, Model model){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user= userRepository.findByUsername(username);

        model.addAttribute("userSkill", userSkillService.findByUserIdAndSkillId(Long.valueOf(id)));

        return "/user/userskill/show";
    }

    @GetMapping("/user/{userId}/userskill/{id}/update")
    public String updateUserSkill( @PathVariable String id, Model model){

        UserSkillCommand userSkillCommand = userSkillToUserSkillCommand
                .convert(userSkillService.findByUserIdAndSkillId(Long.valueOf(id)));

        model.addAttribute("userSkill", userSkillCommand);

        return "user/userskill/userskillform";
    }



    @GetMapping("user/{userId}/userskill/{id}/delete")
    public String deleteUserSkill(@PathVariable String userId,
                                   @PathVariable String id){

        userSkillService.deleteById(Long.valueOf(userId), Long.valueOf(id));

        return "redirect:/user/userskill";
    }
}
















