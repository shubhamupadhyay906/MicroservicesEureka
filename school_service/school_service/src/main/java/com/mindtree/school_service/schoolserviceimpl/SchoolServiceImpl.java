package com.mindtree.school_service.schoolserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.school_service.model.School;
import com.mindtree.school_service.schoolrepository.SchoolRepository;
import com.mindtree.school_service.schoolservice.SchoolService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;

	

	@Override
	public void addNewSchool(School student) {
		schoolRepository.save(student);
	}



	@Override
	public Optional<School> getSchool(Integer schoolId) {
		return schoolRepository.findById(schoolId);
		
	}

}
