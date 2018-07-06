package com.i2i.cell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.i2i.cell.entity.Customer;
import com.i2i.cell.repo.CustomerRepo;

@Service
public class CustomerUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByUsername(username);

		if (customer == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new CustomerUserDetails(customer);
	}

}
