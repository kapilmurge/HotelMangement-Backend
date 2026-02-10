package com.mini.hotel.controller;

import com.mini.hotel.model.HotelDetailsDTO;
import com.mini.hotel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")  // the url will look like http://localhost:8080/test

public class TestController {
    @GetMapping("")
    public String helloWorld(){
        return "hello world !" ;
    }

    @GetMapping("/hello")
    public String helloWorldNew(){
        return "hello world without base route !" ;
    }

    // this is field level dependency injection
//    @Autowired                           // if we dont use this it will return statusCode : 500 error ile internal server error
//    private TestService testservice;    // so here we used this dependency injection because here we are not creating any object of TestService
                                        // therefore after using @Autowired

    // constructor injection
    private TestService testservice;
    public TestController(TestService testservice){
        this.testservice=testservice;

    }

    @PostMapping("/create")
    public ResponseEntity<String> create (@RequestBody HotelDetailsDTO hotelDetails){
        String Response =testservice.create(hotelDetails) ;
        return new ResponseEntity<>(Response, HttpStatus.CREATED);
    }







}

