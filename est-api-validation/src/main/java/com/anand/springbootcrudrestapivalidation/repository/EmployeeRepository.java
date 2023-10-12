	package com.anand.springbootcrudrestapivalidation.repository;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.anand.springbootcrudrestapivalidation.model.Employee;
	
	@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	}
