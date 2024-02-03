package com.example.phonebookapi.Repozytory;

import com.example.phonebookapi.Entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepozytory extends JpaRepository<Database, Long> {

    List<Database> findByNameAndAndSurname(String name, String surname);

    List<Database> findByName(String name);

    Page<Database> findByAproveTrue(Pageable pageable);
}
