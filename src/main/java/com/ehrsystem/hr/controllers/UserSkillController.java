package com.ehrsystem.hr.controllers;

import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.commands.UserSkillCommand;
import com.ehrsystem.hr.services.UserService;
import com.ehrsystem.hr.services.UserSkillService;
import lombok.extern.slf4j.Slf4j;
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

    public UserSkillController(UserSkillService userSkillService, UserService userService) {
        this.userSkillService = userSkillService;
        this.userService = userService;
    }

    @GetMapping("/user/{userId}/userskill")
    public String listUserSkill(@PathVariable String userId, Model model){

        // use command object to avoid lazy load errors in Thymeleaf.
        model.addAttribute("user", userService.findCommandById(Long.valueOf(userId)));

        return "user/userskill/list";
    }


    @GetMapping("/user/{userId}/userskill/{id}/show")
    public String showUserSkill(@PathVariable String userId,
                                       @PathVariable String id, Model model){
        model.addAttribute("userSkill", userSkillService.findByUserIdAndSkillId(Long.valueOf(userId), Long.valueOf(id)));

        return "user/userskill/show";
    }


    @GetMapping("/user/{userId}/userskill/new")
    public String newUserSkill(@PathVariable String userId, Model model){

        //make sure we have a good id value
        UserCommand userCommand = userService.findCommandById(Long.valueOf(userId));
        //todo raise exception if null

        //need to return back parent id for hidden form property
        UserSkillCommand userSkillCommand = new UserSkillCommand();
        userSkillCommand.setThisUserId(Long.valueOf(userId));
        model.addAttribute("userSkill", userSkillCommand);

        return "user/userskill/userskillform";
    }

    @GetMapping("/user/{userId}/userskill/{id}/update")
    public String updateUserSkill(@PathVariable String userId,
                                         @PathVariable String id, Model model){
        model.addAttribute("userSkill", userSkillService.findByUserIdAndSkillId(Long.valueOf(userId), Long.valueOf(id)));

        return "user/userskill/userskillform";
    }

    @PostMapping("user/{userId}/userskill")
    public String saveOrUpdate(@ModelAttribute UserSkillCommand command){
        UserSkillCommand savedCommand = userSkillService.saveUserSkillCommand(command);

        log.debug("saved user id:" + savedCommand.getThisUserId());
        log.debug("saved userSkill id:" + savedCommand.getUserSkillId());

        return "redirect:/user/" + savedCommand.getThisUserId() + "/userskill/"+ savedCommand.getUserSkillId() + "/show";
    }



    @GetMapping("user/{userId}/userskill/{id}/delete")
    public String deleteUserSkill(@PathVariable String userId,
                                   @PathVariable String id){

        userSkillService.deleteById(Long.valueOf(userId), Long.valueOf(id));

        return "redirect:/user/" + userId + "/userskill";
    }
}
















