package com.hotel.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;



@Setter
@Getter
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name =  "hotelId" ,  nullable = false)
    private  String hotelId;


    @Column(name = "hotelName" , length = 100 , nullable = false)
    private  String name;

    @Column(length = 100 , nullable = false)
    private  String  location;


    @Lob
    @Column(nullable = false)
    private  String about;

}
