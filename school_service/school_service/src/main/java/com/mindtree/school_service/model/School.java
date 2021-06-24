package com.mindtree.school_service.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schoolId;
	private String schoolName;
	private String location;

	@OneToMany
	private List<Student> student;
}
