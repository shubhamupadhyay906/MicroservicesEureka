package com.mindtree.school_service.schoolservice;

import java.util.List;
import java.util.Optional;

import com.mindtree.school_service.model.School;

public interface SchoolService {

	public Optional<School> getSchool(Integer schoolId);

	public void addNewSchool(School student);

}
