package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @NotNull(message = "Enter the category id")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;
    @NotEmpty(message = "Enter the title")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;
    @NotEmpty(message = "Enter the content")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;
    @NotNull(message = "Enter the user id")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotEmpty(message = "Enter the date")
    @Column(columnDefinition = "date ")
    private Date publishDate;
}
