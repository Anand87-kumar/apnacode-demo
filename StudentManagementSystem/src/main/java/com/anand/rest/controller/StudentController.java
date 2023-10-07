package com.anand.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anand.rest.response.BasicResponseMsg;
import com.anand.rest.response.StudentRequestVo;
import com.anand.rest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("saveStudent")
	public ResponseEntity<BasicResponseMsg> saveStudent(@RequestBody StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

		try {

			response = studentService.saveStudent(studentRequestVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BasicResponseMsg>(response, HttpStatus.OK);

	}
	@GetMapping("getStudent")
	public ResponseEntity<BasicResponseMsg> getStudent(@RequestBody StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

		try {
			 response = studentService. getStudent(studentRequestVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BasicResponseMsg>(response, HttpStatus.OK);
		
	}
	@PutMapping("updateStudent")
	public ResponseEntity<BasicResponseMsg> updateStudent(@RequestBody StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

		try {
			 response = studentService. updateStudent(studentRequestVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BasicResponseMsg>(response, HttpStatus.OK);
		
	}
	@DeleteMapping("deleteStudent")
	public ResponseEntity<BasicResponseMsg> deleteStudent(@RequestBody StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

		try {
			 response = studentService. deleteStudent(studentRequestVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BasicResponseMsg>(response, HttpStatus.OK);
		
	} 
	@PostMapping("/sortingStudent")
	public ResponseEntity<BasicResponseMsg> sortingStudent(@RequestBody StudentRequestVo studentRequestVo){
		BasicResponseMsg response = new BasicResponseMsg();
		try {
			 response = studentService. sortingStudent(studentRequestVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BasicResponseMsg>(response, HttpStatus.OK);
	}

}
