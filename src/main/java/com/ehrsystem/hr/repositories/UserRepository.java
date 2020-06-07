package com.ehrsystem.hr.repositories;

import com.ehrsystem.hr.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
