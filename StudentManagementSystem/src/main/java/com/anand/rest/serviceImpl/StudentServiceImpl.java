package com.anand.rest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anand.rest.dao.StudentDao;
import com.anand.rest.model.Student;
import com.anand.rest.response.BasicResponseMsg;
import com.anand.rest.response.StudentRequestVo;
import com.anand.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();
		try {
			Student s = new Student();
			s.setAddress(studentRequestVo.getAddress());
			s.setAge(studentRequestVo.getAge());
			s.setMoblieNumber(studentRequestVo.getMoblieNumber());
			s.setName(studentRequestVo.getName());
			s.setRollNo(studentRequestVo.getRollNo());
			Student save = studentDao.save(s);
			response.setData(save.getId());
			response.setMessage("student saved");
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BasicResponseMsg getStudent(StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

		try {
			// Optional<Student> findById=studentDao.findById(Long.valueOf(studentRequestVo.getId()));
			List<Student> findAll = studentDao.findAll();
			if (!findAll.isEmpty()) {
				response.setData(200);
				response.setMessage("data found");
				response.setData(findAll);
//			if(findById.isPresent()) {
//				Student student=findById.get();
//				response.setData(200);
//				response.setMessage("data found");
//				response.setData(student);
			} else {
				response.setData(400);
				response.setMessage("data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BasicResponseMsg updateStudent(StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

	try {
		Optional<Student> findById=studentDao.findById(Long.valueOf(studentRequestVo.getId()));
		if(findById.isPresent()) {
			Student student = findById.get();
			student.setName(studentRequestVo.getName());
			student.setRollNo(studentRequestVo.getRollNo());
			Student save = studentDao.save(student);
			
			response.setData(save.getId());
			response.setMessage("student update");
			response.setStatus(200);
		}else {
			response.setData(400);
			response.setMessage("data not found");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return response;
	}
	@Override
	public BasicResponseMsg deleteStudent(StudentRequestVo studentRequestVo) {
		BasicResponseMsg response = new BasicResponseMsg();

	try {
		Optional<Student> findById=studentDao.findById(Long.valueOf(studentRequestVo.getId()));
		if(findById.isPresent()) {
			Student student = findById.get();
			studentDao.delete(student);
			response.setMessage("student delete");
			response.setStatus(200);
		}else {
			response.setData(400);
			response.setMessage("data not found");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return response;
	}

//	@Override
//	public BasicResponseMsg sortingStudent(StudentRequestVo studentRequestVo) {
//		BasicResponseMsg response = new BasicResponseMsg();
//	    Sort sortByAge = Sort.by(Sort.Direction.ASC, "rollNo");
//	    List<Student> sortedStudents = studentDao.findAll(sortByAge);
//		return response;
//	}
	@Override
	public BasicResponseMsg sortingStudent(StudentRequestVo studentRequestVo) {
	    BasicResponseMsg response = new BasicResponseMsg();

	    try {
	    	//Sort sortByRollNo = Sort.by(Sort.Direction.ASC, "rollNo");
	    	//List<Student> sortedStudents = studentDao.findAll(Sort.by(studentRequestVo.getSortDirection(), "rollNo"));
	    	
	    	Sort sortByRollNo = Sort.by(Sort.Direction.ASC, "rollNo");
	    	List<Student> sortedStudents = studentDao.findAll(sortByRollNo);
	    	response.setData(sortedStudents);
	        response.setMessage("Students sorted by createdDate in " + studentRequestVo.getSortDirection() + " order.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.setMessage("An error occurred while sorting students.");
	    }

	    return response;
	}



}