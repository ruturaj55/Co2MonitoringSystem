package com.uni.co2ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Co2MonitoringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(Co2MonitoringSystemApplication.class, args);
	}

}
