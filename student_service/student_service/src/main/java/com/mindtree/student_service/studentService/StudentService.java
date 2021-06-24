package com.mindtree.student_service.studentService;

import java.util.List;
import java.util.Optional;

import com.mindtree.student_service.exception.StudentNameNotFound;
import com.mindtree.student_service.model.Student;

public interface StudentService {
	
	public List<Student> getStudents(Integer schoolId) throws StudentNameNotFound;
	
	public void addNewStudent(Student student);

}
