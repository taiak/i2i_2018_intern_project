package com.i2i.cell.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.i2i.cell.entity.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Customer findByUsername(String username);

}
