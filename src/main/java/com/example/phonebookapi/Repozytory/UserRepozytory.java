package com.example.phonebookapi.Repozytory;

import com.example.phonebookapi.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepozytory extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsUserByEmail(String email);
}