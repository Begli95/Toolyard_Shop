package com.toolyard.toolyard_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ToolyardShopApplication {
	//13.58
	public static void main(String[] args) {
		//SpringApplication.run(ToolyardShopApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(ToolyardShopApplication.class, args);
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		System.out.println(encoder.encode("pass"));
	}

}
