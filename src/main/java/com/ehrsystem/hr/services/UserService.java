package com.ehrsystem.hr.services;

import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.model.User;

import java.util.Set;

public interface UserService {

    Set<User> getUser();

    User save(User user);

    UserCommand saveUserCommand(UserCommand command);

    UserCommand findCommandById(Long l);

    User findById(Long l);

    void deleteById(Long idToDelete);

    User update(User updateUser,User userLogged);
}
