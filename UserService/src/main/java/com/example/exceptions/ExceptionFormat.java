package com.example.exceptions;

import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionFormat {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private  String message;
    private String uri;
}
