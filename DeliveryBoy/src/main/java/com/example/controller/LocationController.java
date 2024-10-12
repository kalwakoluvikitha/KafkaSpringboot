package com.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	
	@Autowired
	private KafkaService kafkaService;
	
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation()
	{
		this.kafkaService.updateLocation("("+Math.round(Math.random()*100)+","+Math.round(Math.random()*100)+")");
		
		return new ResponseEntity(Map.of("message","location update"),HttpStatus.OK);
	}
	
	
	@PostMapping("/time")
	public ResponseEntity<?> updatetime()
	
	{
		for(int i=0;i<=10;i++)
		{
       LocalDateTime currentDateTime = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convert LocalDateTime to String
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);
        
        
		this.kafkaService.dateandtime(formattedDateTime);
		}
       
		
		return new ResponseEntity(Map.of("message","time update"),HttpStatus.OK);
	}

	
	
	
	
	

}
