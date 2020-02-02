package com.codegrasp.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemorestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorestApplication.class, args);
	}

}
