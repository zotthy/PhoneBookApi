package com.example.phonebookapi.Entity;

import org.springframework.stereotype.Service;

@Service
public class DatabaseDtoMapper {
    public DatabaseDto map(Database database){
        DatabaseDto databaseDto = new DatabaseDto();
        databaseDto.setId(database.getId());
        databaseDto.setName(database.getName());
        databaseDto.setSurname(database.getSurname());
        databaseDto.setCity(database.getCity());
        databaseDto.setStreet(database.getStreet());
        databaseDto.setBuildnumber(database.getBuildnumber());
        databaseDto.setNumbertel(database.getNumbertel());
        databaseDto.setAprove(database.isAprove());
        return databaseDto;
    }
    public Database map(DatabaseDto databaseDto){
        Database database = new Database();
        database.setId(databaseDto.getId());
        database.setName(databaseDto.getName());
        database.setSurname(databaseDto.getSurname());
        database.setStreet(databaseDto.getStreet());
        database.setBuildnumber(databaseDto.getBuildnumber());
        database.setNumbertel(databaseDto.getNumbertel());
        database.setAprove(databaseDto.isAprove());
        return database;
    }
}
