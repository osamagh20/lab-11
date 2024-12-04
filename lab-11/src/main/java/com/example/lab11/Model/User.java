package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty(message = "Enter the username")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @NotEmpty(message = "Enter the password")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "Enter the email")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;
    @NotEmpty(message = "Enter the date")
    @Column(columnDefinition = "date ")
    private Date registration_date;
}
