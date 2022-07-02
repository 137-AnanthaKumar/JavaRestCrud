package com.example.roleBaseSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.roleBaseSecurity.repo.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class RoleBaseSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(RoleBaseSecurityApplication.class, args);

		
		
		
		
	}

}
