package com.mindtree.student_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.student_service.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findBySchoolId(Integer schoolId);

}
