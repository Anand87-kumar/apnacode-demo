package com.anand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}