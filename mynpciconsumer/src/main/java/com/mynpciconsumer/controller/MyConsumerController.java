package com.mynpciconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mynpciconsumer.dto.MyEmployee;

@RestController
@RequestMapping("v1/consumers")
public class MyConsumerController {
	
	@Autowired
	DiscoveryClient ds;
	
	@GetMapping
	public List<MyEmployee> getAllData(){
		
		List<ServiceInstance> ss = ds.getInstances("NPCIBATCH8FIRSTAPI");
		ServiceInstance s1 =ss.get(0);
		
		String url = s1.getUri().toString();
		
		RestTemplate rTemp = new RestTemplate();
		
		return rTemp.getForObject(url+"/v1/employees", List.class);
	}
	

}











