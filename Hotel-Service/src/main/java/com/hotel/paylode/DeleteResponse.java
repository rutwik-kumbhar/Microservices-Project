package com.hotel.paylode;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class DeleteResponse {

    private  String message;
    private  boolean status;
}
