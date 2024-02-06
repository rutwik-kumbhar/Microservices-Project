package com.example.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;

    @Column(length =  20 , nullable = false)
    private  String firstName;

    @Column(length =  20 , nullable = false)
    private String lastName;

    @Column(length = 20 , nullable = false , unique = true )
    private  String email;


    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
