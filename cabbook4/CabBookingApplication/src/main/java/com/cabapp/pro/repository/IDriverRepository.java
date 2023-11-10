package com.cabapp.pro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabapp.pro.entity.Driver;



@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {

	
	
	@Query("from Driver d where d.available=true")
	public List<Driver> findByAvailable();
}
