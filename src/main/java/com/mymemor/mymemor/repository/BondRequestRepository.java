package com.mymemor.mymemor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymemor.mymemor.model.BondRequest;
 

public interface BondRequestRepository extends JpaRepository< BondRequest, Long>  {
	 

}