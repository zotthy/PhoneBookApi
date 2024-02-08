package com.example.phonebookapi.Dtos;

import com.example.phonebookapi.Dtos.UserSecDto;
import com.example.phonebookapi.Entity.User;
import com.example.phonebookapi.Entity.UserRole;

import java.util.Set;
import java.util.stream.Collectors;

public class UserSecDtoMapper {
    public static UserSecDto map(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserSecDto(email, password, roles);
    }
}
