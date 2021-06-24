package com.mindtree.school_service.schoolcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.school_service.model.Responses;
import com.mindtree.school_service.model.School;
import com.mindtree.school_service.model.Student;
import com.mindtree.school_service.schoolservice.SchoolService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@Autowired
	RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@GetMapping("/getSchools/{schoolId}")
	public School getSchool(@PathVariable Integer schoolId) {
		Optional<School> school = schoolService.getSchool(schoolId);
		School schools = school.get();
		List<Student> response = restTemplate.exchange("http://student-service/getstudents/{schoolId}",
				HttpMethod.GET, null,List.class
				, schoolId).getBody();
		schools.setStudent(response);
		return schools;

	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@PostMapping("/addNewSchool")
	public Responses addNewSchool(@RequestBody School school) {
		schoolService.addNewSchool(school);
		ResponseEntity<School> responseEntity = new ResponseEntity<School>(school, HttpStatus.CREATED);
		Responses response = new Responses("success", responseEntity);
		log.info("new student added");
		return response;

	}

}
