package com.ecom.Shakti.Bazaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ecom.Shakti.Bazaar.entity")
public class ShaktiBazaarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShaktiBazaarApplication.class, args);
	}

}
