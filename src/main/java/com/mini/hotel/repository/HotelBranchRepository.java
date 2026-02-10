package com.mini.hotel.repository;

import com.mini.hotel.entity.HotelBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelBranchRepository extends JpaRepository<HotelBranch,Integer> {

    List<HotelBranch> findByHotelId(Integer hotelId);

}


