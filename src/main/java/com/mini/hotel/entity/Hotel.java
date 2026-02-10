package com.mini.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="hotel")
public class Hotel {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="hotel_id_seq", sequenceName= "seq_hotel_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hotel_id_seq" )
    @Column (name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating")
    private Integer rating;
}
