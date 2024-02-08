package com.example.phonebookapi.Service;

import com.example.phonebookapi.Dtos.UserRegisterDto;
import com.example.phonebookapi.Dtos.UserRegisterDtoMapper;
import com.example.phonebookapi.Entity.User;
import com.example.phonebookapi.Entity.UserRole;
import com.example.phonebookapi.Exceptions.UserAlreadyExistsException;
import com.example.phonebookapi.Repozytory.UserRoleRepository;
import com.example.phonebookapi.Repozytory.UserRepozytory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegisterService {
    private final UserRegisterDtoMapper userRegisterDtoMapper;
    private final UserRepozytory userRepozytory;
    private final UserRoleRepository userRoleRepository;
    private final String USER_ROLE = "USER";
    private final PasswordEncoder passwordEncoder;


    public UserRegisterService(UserRegisterDtoMapper userRegisterDtoMapper, UserRepozytory userRepozytory,
                               UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRegisterDtoMapper = userRegisterDtoMapper;
        this.userRepozytory = userRepozytory;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(UserRegisterDto userRegisterDto){
        if (userRepozytory.existsUserByEmail(userRegisterDto.getEmail())){
            throw new UserAlreadyExistsException("User with the same email!");
        }
        String encodePassword = passwordEncoder.encode(userRegisterDto.getPassword());
        User newUser = UserRegisterDtoMapper.map(userRegisterDto);
        newUser.setPassword(encodePassword);
        UserRole userRole = userRoleRepository.findByName(USER_ROLE)
                        .orElseThrow(()->new RuntimeException("Not found"));
        newUser.getRoles().add(userRole);
        userRepozytory.save(newUser);
        System.out.println(encodePassword);
        System.out.println(newUser);
    }
}
