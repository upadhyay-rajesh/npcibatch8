package com.npcifirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npcifirst.model.Customer;
import com.npcifirst.service.EmployeeServiceInterface;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
	
	@Autowired
	
	private EmployeeServiceInterface eService;
	
	@GetMapping
	public List<Customer> getAll() {
		return eService.getAllCustomerService();
	}
	
	@GetMapping("/{useremail}")
	public Customer getCustomerById(@PathVariable("useremail") String email) {
		return eService.getCustomerByIdService(email);
	}
	
	@PostMapping
	public String createProfile( @RequestBody Customer cust) {
		int i = eService.createProfileService(cust);
		if(i>0) {
			return "profile created successfully";
		}
		else {
			return "could not create profile";
		}
	}
	
	@DeleteMapping("/{useremail}")
	public String deleteRecordProfile(@PathVariable("useremail") String email) {
		return eService.deleteCustomerById(email);
	}
	
	@PutMapping("/{useremail}")
	public String editProfile(@RequestBody Customer cust,@PathVariable("useremail") String email) {
		cust.setEmail(email);
		return eService.updateCustomerRecordService(cust);
	}

}













