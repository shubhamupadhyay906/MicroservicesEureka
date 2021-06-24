package com.mindtree.school_service.schoolrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.school_service.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

}
