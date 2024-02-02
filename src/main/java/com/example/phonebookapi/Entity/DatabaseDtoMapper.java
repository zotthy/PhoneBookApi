package com.example.phonebookapi.Entity;

import org.springframework.stereotype.Service;

@Service
public class DatabaseDtoMapper {
    DatabaseDto map(Database database){
        DatabaseDto databaseDto = new DatabaseDto();
        databaseDto.setId(database.getId());
        databaseDto.setName(database.getName());
        databaseDto.setSurname(database.getSurname());
        databaseDto.setStreet(database.getStreet());
        databaseDto.setBuildnumber(database.getBuildnumber());
        databaseDto.setNumbertel(database.getNumbertel());
        return databaseDto;
    }
}
