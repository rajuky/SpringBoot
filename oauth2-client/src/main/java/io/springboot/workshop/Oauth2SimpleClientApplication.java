package io.springboot.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class Oauth2SimpleClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SimpleClientApplication.class, args);
	}
	
}
