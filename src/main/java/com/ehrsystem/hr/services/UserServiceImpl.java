package com.ehrsystem.hr.services;


import com.ehrsystem.hr.commands.UserCommand;
import com.ehrsystem.hr.converters.UserCommandToUser;
import com.ehrsystem.hr.converters.UserToUserCommand;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserCommand userToUserCommand;
    private final UserCommandToUser userCommandToUser;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserToUserCommand userToUserCommand, UserCommandToUser userCommandToUser,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userToUserCommand = userToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Set<User> getUser() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }



    @Override
    public User save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);


        return userRepository.save(user);
    }

    @Override
    public UserCommand saveUserCommand(UserCommand command) {
        User detachedUser = userCommandToUser.convert(command);

        User savedUser = userRepository.save(detachedUser);

        return userToUserCommand.convert(savedUser);
    }

    @Override
    public User findById(Long l) {

        Optional<User> userOptional = userRepository.findById(l);

        return userOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        userRepository.deleteById(idToDelete);
    }

    @Override
    @Transactional
    public UserCommand findCommandById(Long l) {
        return userToUserCommand.convert(findById(l));
    }
}