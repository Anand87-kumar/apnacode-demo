package com.anand.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.rest.model.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
