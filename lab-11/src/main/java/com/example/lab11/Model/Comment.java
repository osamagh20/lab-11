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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @NotNull(message = "Enter the user id")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "Enter the post id")
    @Column(columnDefinition = "int not null")
    private Integer postId;
    @NotEmpty(message = "Enter the content")
    @Column(columnDefinition = "varchar(20) not null")
    private String content;
    @NotEmpty(message = "Enter the date")
    @Column(columnDefinition = "date ")
    private Date commentDate;
}
