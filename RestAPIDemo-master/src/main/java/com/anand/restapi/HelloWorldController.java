package com.anand.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@ApiOperation(value="say hello swagger", notes="this just say hello")
	@GetMapping("/say")
	public String sayHello() {
		return "Hello Swagger";
	}
}
