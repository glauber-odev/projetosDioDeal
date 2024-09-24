package br.com.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableAutoConfiguration
public class RestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSpringApplication.class, args);
	}

}
