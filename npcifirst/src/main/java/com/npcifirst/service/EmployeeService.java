package com.npcifirst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.npcifirst.dao.EmployeeDAOInterface;
import com.npcifirst.model.Customer;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeDAOInterface edao;

	@Override
	public int createProfileService(Customer cust) {
		int i=0;
		edao.save(cust);
		i=1;
		return i;
	}

	@Override
	public List<Customer> getAllCustomerService() {
		// TODO Auto-generated method stub
		return edao.findAll();
	}

	@Override
	public Customer getCustomerByIdService(String email) {
		Optional<Customer> ll = edao.findById(email);
		return ll.get();
	}

	@Override
	public String deleteCustomerById(String email) {
		edao.deleteById(email);
		return "record deleted ";
	}

	@Override
	public String updateCustomerRecordService(Customer cust) {
		edao.saveAndFlush(cust);
		return "record updated ";
	}

}







