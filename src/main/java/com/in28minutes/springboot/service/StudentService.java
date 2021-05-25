package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> retrieveStudent(String studentId) {
		return studentRepository.findById(Long.parseLong(studentId));
	}

	public List<Course> retrieveCourses(String studentId) throws Exception {
		Optional<Student> student = retrieveStudent(studentId);

		if (student.isEmpty()) {
			throw new Exception("ERROR! No student found for id : "+studentId);
		}

		return student.get().getCourses();
	}

	public Course retrieveCourse(Long studentId, Long courseId) throws Exception {
		Optional<Student> student = retrieveStudent(studentId.toString());

		if (student.isEmpty()) {
			throw new Exception("ERROR! No student found for id : "+studentId);
		}

		List<Course> courses = student.get().getCourses();

		for (Course course : courses) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Course addCourse(Long studentId, Course course) throws Exception {
		Optional<Student> student = retrieveStudent(studentId.toString());

		if (student.isEmpty()) {
			throw new Exception("ERROR! No student found for id : "+studentId);
		}

		student.get().getCourses().add(course);

		return course;
	}
}