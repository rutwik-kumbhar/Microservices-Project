package com.hotel.services;

import com.hotel.entities.Hotel;
import com.hotel.paylode.DeleteResponse;

import java.util.List;

public interface HotelService {


    /**
     * This method for create new hotel
     * @param hotel
     * @return newly created hotel entity
     */
    Hotel createHotel(Hotel hotel);


    /**
     * This method for get hotel bys id
     * @param hotelId
     * @return hotel entity
     */
    Hotel getHotelById(String hotelId);


    /**
     * This method for get all hotels
     * @return list of hotel
     */
    List<Hotel> getAllHotels();

    /**
     * This method for update existing hotel
     * @param hotelId
     * @param hotel
     * @return update hotel entity
     */
    Hotel updateHotel(String hotelId , Hotel hotel);

    /**
     * This method for delete existing hotel
     * @param hotelId
     * @return delete response dto
     */
    DeleteResponse deleteHotel(String hotelId);

}
