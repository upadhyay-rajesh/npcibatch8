package com.myconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myconsumer.dto.Customer;

@RestController
@RequestMapping("v1/consumers")
public class MyConsumerController {
	
	//@Autowired
	//DiscoveryClient ds;
	
	@Autowired
	RestTemplate rtemp;
	
	@GetMapping
	public List<Customer> getAll(){
		
		//List<ServiceInstance> ss =ds.getInstances("NPCIFIRST");
		//ServiceInstance s1 =  ss.get(0);
		
		//String baseUrl= s1.getUri().toString();
		
		
		//RestTemplate rtemp = new RestTemplate();
		
		List<Customer> ll = rtemp.getForObject("http://NPCIFIRST/v1/employee", List.class);
		
		return ll;
	}
}













