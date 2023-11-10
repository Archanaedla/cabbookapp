package com.cabapp.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabapp.pro.entity.Cab;


@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer> {

}
