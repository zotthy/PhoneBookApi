package com.example.phonebookapi.Dtos;

import java.util.Set;

public record UserSecDto(String email,String password,Set<String> roles) {
}