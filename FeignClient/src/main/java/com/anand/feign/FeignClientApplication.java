package com.anand.feign;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.feign.client.UserClient;
import com.anand.feign.dto.UserResponse;


@SpringBootApplication
@RestController
@EnableFeignClients

public class FeignClientApplication {
	@Autowired
	private UserClient client;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser() {
		return client.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}