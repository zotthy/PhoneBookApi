package com.example.phonebookapi.Service;

import com.example.phonebookapi.Entity.Database;
import com.example.phonebookapi.Entity.DatabaseDto;
import com.example.phonebookapi.Entity.DatabaseDtoMapper;
import com.example.phonebookapi.Repozytory.PhoneRepozytory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PhoneService {
    private final PhoneRepozytory phoneRepozytory;
    private final DatabaseDtoMapper databaseDtoMapper;

    public PhoneService(PhoneRepozytory phoneRepozytory, DatabaseDtoMapper databaseDtoMapper) {
        this.phoneRepozytory = phoneRepozytory;
        this.databaseDtoMapper = databaseDtoMapper;
    }

    public Page<DatabaseDto> find(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Database> databasePage = phoneRepozytory.findByAproveTrue(pageable);

        List<DatabaseDto> dtoList = databasePage.getContent().stream()
                .map(database -> databaseDtoMapper.map(database))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, databasePage.getTotalElements());
    }


    public DatabaseDto save(DatabaseDto databaseDto){
        Database database = databaseDtoMapper.map(databaseDto);
        Database savedatabase = phoneRepozytory.save(database);
        return databaseDtoMapper.map(savedatabase);
    }

    public Optional<DatabaseDto> getDataByid(Long id){
        return  phoneRepozytory.findById(id)
                .map(databaseDtoMapper::map);
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
