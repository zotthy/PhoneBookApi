package com.example.phonebookapi.Security;

import com.example.phonebookapi.Dtos.UserSecDto;
import com.example.phonebookapi.Dtos.UserSecDtoMapper;
import com.example.phonebookapi.Repozytory.UserRepozytory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecService {
    private final UserRepozytory userRepozytory;

    public UserSecService(UserRepozytory userRepozytory) {
        this.userRepozytory = userRepozytory;
    }
    public Optional<UserSecDto> findCredentialsByEmail(String email){
        return userRepozytory.findByEmail(email)
                .map(UserSecDtoMapper::map);
    }
}

