package com.mindtree.student_service.exception;

public class StudentNameNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public StudentNameNotFound(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
