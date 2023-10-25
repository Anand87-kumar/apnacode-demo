package com.anand.employeeservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.employeeservice.entity.Employee; 

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> { 

}
