package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumer {
	
	
	
	
	@KafkaListener(topics=AppConstants.Date_time,groupId = AppConstants.GROUP_ID)
	public void updateLocation(String value)
	{
	System.out.println(value);	
		
	}
	
	
	
}
