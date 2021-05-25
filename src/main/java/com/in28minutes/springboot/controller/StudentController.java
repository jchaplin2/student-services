package com.in28minutes.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{studentId}/courses")
	public ResponseEntity<List<Course>> retrieveCoursesForStudent(@PathVariable String studentId) {
		List<Course> courses = null;
		try {
			courses = studentService.retrieveCourses(studentId);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error occurred while retrieving courses.");
		}

		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentId}/courses/{courseId}")
	public ResponseEntity<Course> retrieveDetailsForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
		Course course = null;
		try {
			course = studentService.retrieveCourse(studentId, courseId);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error occurred while retrieving courses for student.");
		}



		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable Long studentId, @RequestBody Course newCourse) {

		Course course = null;
		try {
			 course = studentService.addCourse(studentId, newCourse);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error occurred while adding course.");
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
