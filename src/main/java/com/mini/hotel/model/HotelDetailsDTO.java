package com.mini.hotel.model;

import lombok.Data; // this will automata

import java.util.List;

// this class is used to establish connection between user and application
// with the help of this class user enter the values
// matlab iss class me jo jo variable hoge user wahi value enter kar sakta hai client side
// how this class is establishing the connection.

@Data
public class HotelDetailsDTO {


    // here we didnt set identity i,e id so we have to set in service class explicitly i.e like hotel.setId(1);
    // suppose here we did like this private Integer id;
    // it means we are allowing client ot set the user id too which is not a good practice
    // and if we dont want to do hotel.setId(1); this then we have to set either sequence or either auto increment


    private String name;
    private String imageUrl;
    private Integer rating;
    private List<HotelBranchDTO> branches;


}


 //   this is for test / testservice

//    private String name ;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    private String type;




