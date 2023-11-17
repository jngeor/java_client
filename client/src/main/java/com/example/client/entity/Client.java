package com.example.client.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    private String id;

    private String name;

    private String lastName;

    private String motherName;

    private LocalDateTime creationDate;

    private boolean active;

    public Client(String name, String lastName, String motherName) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.lastName = lastName;
        this.motherName = motherName;
        this.creationDate = LocalDateTime.now();
        this.active = true;
    }
}
