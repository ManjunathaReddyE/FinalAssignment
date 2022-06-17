package com.hbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class HungerboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(HungerboxApplication.class, args);
	}

}
