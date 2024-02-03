package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Entity.DatabaseDto;
import com.example.phonebookapi.Service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("admin")
public class PhoneBookControllerAdmin {
    private final PhoneService phoneService;

    public PhoneBookControllerAdmin(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

}
