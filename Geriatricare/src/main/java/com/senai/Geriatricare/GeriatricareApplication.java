package com.senai.Geriatricare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GeriatricareApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeriatricareApplication.class, args);

	}
}
