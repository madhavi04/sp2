package com.capgemini.inventorymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages= {"com.capgemini.inventorymanagement.*"})
public class InventoryManagementApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(InventoryManagementApplication.class, args);
	}
}
