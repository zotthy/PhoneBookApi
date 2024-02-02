package com.example.phonebookapi.Controller;

import com.example.phonebookapi.Entity.Database;
import com.example.phonebookapi.Service.PhoneService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
public class PhoneBookController {
    private final PhoneService phoneService;

    public PhoneBookController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Database>> pageResponseEntity(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Database> dtoPage = phoneService.findwithpagionation(page, size);
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Database>> searchBy(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname) {

        List<Database> result = phoneService.findnamesurname(name, surname);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Database>> find(@RequestParam(name = "name") String name) {
        List<Database> result = phoneService.findByname(name);
        System.out.println(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
