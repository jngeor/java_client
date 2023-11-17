package com.example.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientListDto {

    private String id;

    private String fullName;

    public ClientListDto(String id, String name, String lastName, String motherName) {
        this.id = id;
        this.fullName = name + " " + lastName + " " + motherName;
    }

}
