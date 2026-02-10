package com.mini.hotel.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="hotel_branch")
public class HotelBranch {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name="hotel_branch_seq_id", sequenceName= "seq_hotel_branch_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hotel_branch_seq_id" )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="rating")
    private Integer rating ;

    @Column(name = "address")
    private String address;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName="id")
    private Hotel hotel ;


}


