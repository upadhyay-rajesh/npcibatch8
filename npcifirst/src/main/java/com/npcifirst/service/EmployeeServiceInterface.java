package com.npcifirst.service;

import java.util.List;

import com.npcifirst.model.Customer;

public interface EmployeeServiceInterface {

	int createProfileService(Customer cust);

	List<Customer> getAllCustomerService();

	Customer getCustomerByIdService(String email);

	String deleteCustomerById(String email);

	String updateCustomerRecordService(Customer cust);

}
