package com.anand.rest.service;

import com.anand.rest.response.BasicResponseMsg;
import com.anand.rest.response.StudentRequestVo;

public interface StudentService {

	BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo);

	BasicResponseMsg getStudent(StudentRequestVo studentRequestVo);

	BasicResponseMsg updateStudent(StudentRequestVo studentRequestVo);

	BasicResponseMsg deleteStudent(StudentRequestVo studentRequestVo);

	BasicResponseMsg sortingStudent(StudentRequestVo studentRequestVo);
	
	
}
