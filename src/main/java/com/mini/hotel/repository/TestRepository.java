package com.mini.hotel.repository;


import com.mini.hotel.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {


}
