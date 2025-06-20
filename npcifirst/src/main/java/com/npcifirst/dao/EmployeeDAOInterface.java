package com.npcifirst.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npcifirst.model.Customer;

@Repository
public interface EmployeeDAOInterface extends JpaRepository<Customer, String>{

}
