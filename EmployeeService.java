package com.anand.employeeservice.service;


import org.modelmapper.ModelMapper; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import com.anand.employeeservice.entity.Employee;
import com.anand.employeeservice.repository.EmployeeRepo;
import com.anand.employeeservice.response.AddressResponse;
import com.anand.employeeservice.response.EmployeeResponse;

import java.util.Optional; 

@Service
public class EmployeeService { 

	@Autowired
	private EmployeeRepo employeeRepo; 

	@Autowired
	private ModelMapper mapper; 

	@Autowired
	private WebClient webClient; 

	public EmployeeResponse getEmployeeById(int id) { 

		Optional<Employee> employee = employeeRepo.findById(id); 
		if (employee.isPresent()) {
            EmployeeResponse employeeResponse = mapper.map(employee.get(), EmployeeResponse.class);

            try {
                AddressResponse addressResponse = webClient.get()
                        .uri("/address/" + id)
                        .retrieve()
                        .bodyToMono(AddressResponse.class)
                        .block();
                employeeResponse.setAddressResponse(addressResponse);
            } catch (HttpClientErrorException.BadRequest | HttpServerErrorException e) {
                 e.printStackTrace();
            }

            return employeeResponse;
        } else {
            
            return null; 
        }
    }
}







