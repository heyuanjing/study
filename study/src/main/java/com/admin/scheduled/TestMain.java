package com.admin.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class TestMain {

	//@Scheduled(cron="0/10 * * * * * ")
	public void test(){
		System.out.println("frank love jade");
	}
	
}
	