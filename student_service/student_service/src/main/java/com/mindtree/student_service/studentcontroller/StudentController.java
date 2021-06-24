package com.mindtree.student_service.studentcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.student_service.exception.StudentNameNotFound;
import com.mindtree.student_service.model.Responses;
import com.mindtree.student_service.model.Student;
import com.mindtree.student_service.studentService.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/getstudents/{schoolId}")
	public ResponseEntity<List<Student>> getStudents(@PathVariable Integer schoolId) throws StudentNameNotFound {
		List<Student> students = studentservice.getStudents(schoolId);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@PostMapping("/addnewstudent")
	public Responses addNewStudent(@RequestBody Student student) throws StudentNameNotFound {
		if(student.getName().equals("")||student.getName()==null||student.getStandard().equals("")||student.getStandard()==null) {
			log.error("Error in controller");
			throw new StudentNameNotFound("Fields can't be empty");
		}
		studentservice.addNewStudent(student);
		log.info("New student added");
		ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(student, HttpStatus.CREATED);
		Responses response = new Responses("success", responseEntity);
		log.info("new student added");
		return response;
	}

}
