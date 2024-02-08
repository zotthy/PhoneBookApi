package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Dtos.UserRegisterDto;
import com.example.phonebookapi.Dtos.UserRegisterDtoMapper;
import com.example.phonebookapi.Exceptions.UserAlreadyExistsException;
import com.example.phonebookapi.Service.UserRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final UserRegisterService userRegisterService;
    private final UserRegisterDtoMapper userRegisterDtoMapper;

    public RegisterController(UserRegisterService userRegisterService, UserRegisterDtoMapper userRegisterDtoMapper) {
        this.userRegisterService = userRegisterService;
        this.userRegisterDtoMapper = userRegisterDtoMapper;
    }

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        try {
            userRegisterService.register(userRegisterDto);
            return new ResponseEntity<>("register is sucessfull", HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred during registration", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
