package com.example.phonebookapi.Entity;

import java.util.Set;

public record UserSecDto(String email,String password,Set<String> roles) {
}