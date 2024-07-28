package com.example.NewProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewProjectApplication {
//https://localhost:5500/em
	public static void main(String[] args) {
		var ctx = SpringApplication.run(NewProjectApplication.class, args);
		System.out.println("Hello spring boot");
	}

}
