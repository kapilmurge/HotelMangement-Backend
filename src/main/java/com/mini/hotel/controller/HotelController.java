package com.mini.hotel.controller;


import com.mini.hotel.model.HotelBranchDTO;
import com.mini.hotel.model.HotelDetailsDTO;
import com.mini.hotel.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService=hotelService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody HotelDetailsDTO hotelDetailsDTO ){
        String response = hotelService.create(hotelDetailsDTO) ;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<HotelDetailsDTO>> get(){
        return new ResponseEntity<>(hotelService.getHotels(), HttpStatus.OK);
    }





}
