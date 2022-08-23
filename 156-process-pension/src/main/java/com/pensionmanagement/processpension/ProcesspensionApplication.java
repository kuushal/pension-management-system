package com.pensionmanagement.processpension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProcesspensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcesspensionApplication.class, args);
	}

}
