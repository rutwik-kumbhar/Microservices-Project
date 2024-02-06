package com.hotel.services.impl;

import com.hotel.entities.Hotel;
import com.hotel.exceptions.ResourcesNotFoundException;
import com.hotel.paylode.DeleteResponse;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        Optional<Hotel> optional = hotelRepository.findById(hotelId);
        return optional.orElseThrow(() -> new ResourcesNotFoundException("Hotel not found by give id " + hotelId));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel existingHotel = this.getHotelById(hotelId);
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());
        return hotelRepository.save(existingHotel);
    }

    @Override
    public DeleteResponse deleteHotel(String hotelId) {
        Hotel hotel = this.getHotelById(hotelId);
        hotelRepository.delete(hotel);
        return DeleteResponse.builder().message("Hotel Deleted Successfully").status(true).build();
    }
}
