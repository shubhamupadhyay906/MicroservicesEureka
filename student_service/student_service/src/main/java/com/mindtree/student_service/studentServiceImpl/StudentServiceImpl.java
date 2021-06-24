package com.mindtree.student_service.studentServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.student_service.exception.StudentNameNotFound;
import com.mindtree.student_service.model.Student;
import com.mindtree.student_service.repository.StudentRepository;
import com.mindtree.student_service.studentService.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudents(Integer schoolId) throws StudentNameNotFound {
		List<Student> students = studentRepository.findBySchoolId(schoolId);
		if(students.isEmpty()) {
			throw new StudentNameNotFound("student not found");
		}
		return students;
	}

	@Override
	public void addNewStudent(Student student) {
		studentRepository.save(student);
	}

}
