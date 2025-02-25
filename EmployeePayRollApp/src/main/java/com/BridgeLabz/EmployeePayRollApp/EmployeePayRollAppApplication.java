package com.BridgeLabz.EmployeePayRollApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class EmployeePayRollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayRollAppApplication.class, args);
	}

}
