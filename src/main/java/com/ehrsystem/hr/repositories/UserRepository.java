package com.ehrsystem.hr.repositories;

import com.ehrsystem.hr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
