package com.hotel.controllers;

import com.hotel.entities.Hotel;
import com.hotel.paylode.DeleteResponse;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    private  final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel  hotel){
        return  new ResponseEntity<Hotel>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<Hotel> getHotel(@PathVariable String id){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(id));
    }


    @GetMapping("/all")
    public  ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Hotel> updateHotel(@PathVariable String id ,@RequestBody Hotel hotel){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotel(id,hotel));
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<DeleteResponse> deleteHotel(@PathVariable String id){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.deleteHotel(id));
    }

}
