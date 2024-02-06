package com.hotel.exceptions;

import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@Builder
public class ExceptionFormat {

    private final LocalDateTime timeStamp = LocalDateTime.now();
    private  String message;
    private  String uri;
}
