package com.example.phonebookapi.Service;

import com.example.phonebookapi.Entity.Database;
import com.example.phonebookapi.Repozytory.PhoneRepozytory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhoneService {
    private final PhoneRepozytory phoneRepozytory;

    public PhoneService(PhoneRepozytory phoneRepozytory) {
        this.phoneRepozytory = phoneRepozytory;
    }

    public List<Database> findAll() {
        return phoneRepozytory.findAll();
    }

    public Page<Database> findwithpagionation(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepozytory.findAll(pageable);
    }

    public List<Database> findByname(String name) {
        return phoneRepozytory.findByName(name);
    }

    public List<Database> findnamesurname(String name, String surname) {
        return phoneRepozytory.findByNameAndAndSurname(name, surname);
    }
}
