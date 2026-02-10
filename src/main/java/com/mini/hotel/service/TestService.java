package com.mini.hotel.service;

import com.mini.hotel.model.HotelDetailsDTO;
import org.springframework.stereotype.Service;


//  if we dont write @Service here then it will give the following error
// Parameter 0 of constructor in com.mini.hotel.controller.TestController required a bean of type 'com.mini.hotel.service.TestService' that could not be found.
@Service
public class TestService {

    private DummyService dummyService;

    public TestService(DummyService dummyService){
        this.dummyService=dummyService;
    }


    public String create(HotelDetailsDTO hotelDetails){
        System.out.println(dummyService.print());
        return " Hotel created successfully with name " + hotelDetails.getName() ; // this functions ouput is passed to testcontroller response entity
    }



}
