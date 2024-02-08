package com.example.phonebookapi.Dtos;

import com.example.phonebookapi.Entity.User;
import com.example.phonebookapi.Entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRegisterDtoMapper {
    public static UserRegisterDto map(User user){
        UserRegisterDto userRegisterDto =  new UserRegisterDto();
        userRegisterDto.setId(user.getId());
        userRegisterDto.setFirstName(user.getFirstName());
        userRegisterDto.setLastName(user.getLastName());
        userRegisterDto.setEmail(user.getEmail());
        userRegisterDto.setPassword(user.getPassword());
        return userRegisterDto;
    }
    public static User map(UserRegisterDto userRegisterDto){
        User user = new User();
        user.setId(userRegisterDto.getId());
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        return user;
    }
}
