package com.mini.hotel.service;

import com.mini.hotel.entity.Hotel;
import com.mini.hotel.entity.HotelBranch;
import com.mini.hotel.model.HotelBranchDTO;
import com.mini.hotel.model.HotelDetailsDTO;
import com.mini.hotel.repository.HotelBranchRepository;
import com.mini.hotel.repository.HotelRepository;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Service
public class HotelService {

//    @Value("${server.port}")
//    private String serverPort;

    private final HotelRepository hotelRepository;
  //  private final HotelBranchRepository hotelBranchRepository;

    public HotelService(HotelRepository hotelRepository /*, HotelBranchRepository hotelBranchRepository */ ) {
        this.hotelRepository = hotelRepository;
     //   this.hotelBranchRepository = hotelBranchRepository;
    }
   
    public String create (HotelDetailsDTO hotelDetailsDTO){

    System.out.println(hotelDetailsDTO); // here we are the mapping the data from dto to entity class

        Hotel hotel = new Hotel();
        // hotel.setId(1); no need to use this as now we have already set auto increament(sequence)
        hotel.setName(hotelDetailsDTO.getName());
        hotel.setImageUrl(hotelDetailsDTO.getImageUrl());
        hotel.setRating(hotelDetailsDTO.getRating());


        Hotel savedHotel = hotelRepository.save(hotel);

        // 2 . Save Hotel Branches
        // this below approach is used when we are using seperate HotelBranchRepositoy
//        if (hotelDetailsDTO.getBranches() != null) {
//            for (HotelBranchDTO branchDTO : hotelDetailsDTO.getBranches()) {
//
//                HotelBranch branch = new HotelBranch();
//                branch.setName(branchDTO.getName());
//                branch.setAddress(branchDTO.getAddress());
//                branch.setRating(branchDTO.getRating());
//                branch.setHotel(savedHotel); // FK set here
//
//                hotelBranchRepository.save(branch);
//            }
//        }

        // instead of above commented part we will do below part i.e. because we are trying to use without repository for Hotel Branch

        // this is a for each loop
//        for (datatype variable : collection) {
//            // use variable
//        }


        // here this below code is used for inserting the data into the hotel branch table without using the repository for hotel branch
        // so here we will enter data into hotel branch entity and then we will set the hotel branch list to the hotel entity and 
        // will automatically save the hotel branch data into the hotel branch table because of the cascade type that we have set in the hotel entity class
       
        for(HotelBranchDTO hotelBranchDTO : hotelDetailsDTO.getBranches()  ){
            HotelBranch branch = new HotelBranch();
            branch.setName(hotelBranchDTO.getName());
            branch.setAddress(hotelBranchDTO.getAddress());
            branch.setRating(hotelBranchDTO.getRating());
            branch.setHotel(hotel); // FK set here
            hotel.getHotelBranches().add(branch); // this will add the branch to the hotel entity's list of branches

        }

        hotel = hotelRepository.save(hotel);




        return "new hotel created " ;
    }

    public List<HotelDetailsDTO> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelDetailsDTO> hotelDetailsDTO = new ArrayList<>();

        for (Hotel hotel : hotels) {
            HotelDetailsDTO hotelDetails = new HotelDetailsDTO();
            hotelDetails.setName(hotel.getName());
            hotelDetails.setImageUrl(hotel.getImageUrl());
            hotelDetails.setRating(hotel.getRating());

            hotelDetailsDTO.add(hotelDetails);
        }


        return hotelDetailsDTO;
    }





    // public List<HotelDetailsDTO> getHotels() {

    //     List<Hotel> hotels = hotelRepository.findAll();
    //     List<HotelDetailsDTO> response = new ArrayList<>();

    //     for (Hotel hotel : hotels) {

    //         // 1️⃣ Hotel DTO
    //         HotelDetailsDTO hotelDTO = new HotelDetailsDTO();
    //         hotelDTO.setName(hotel.getName());
    //         hotelDTO.setImageUrl(hotel.getImageUrl());
    //         hotelDTO.setRating(hotel.getRating());

            // 2️⃣ Fetch branches for this hotel
//            List<HotelBranch> branches =
//                  hotelBranchRepository.findByHotelId(hotel.getId());
//
//            List<HotelBranchDTO> branchDTOs = new ArrayList<>();
//
//            for (HotelBranch branch : branches) {
//                HotelBranchDTO branchDTO = new HotelBranchDTO();
//                branchDTO.setName(branch.getName());
//                branchDTO.setAddress(branch.getAddress());
//                branchDTO.setRating(branch.getRating());
//
//                branchDTOs.add(branchDTO);
//            }

            // 3️  Attach branches to hotel
//            hotelDTO.setBranches(branchDTOs);

    //         response.add(hotelDTO);
    //     }

    //     return response;
    // }








}
