package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerUnitTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@Test
	public void test_retrieveCoursesForStudent() throws Exception{
		Course course1 = new Course("Spring", "10 Steps", "Learn Maven Import Project First Example Second Example");
		Course course2 = new Course( "Spring MVC", "10 Examples", "Learn Maven Import Project First Example Second Example");
		Course course3 = new Course("Spring Boot", "6K Students", "Learn Maven Learn Spring Learn Spring MVC First Example Second Example");
		Course course4 = new Course("Maven", "Most popular maven course on internet!", "Pom.xml Build Life Cycle Parent POM Importing into Eclipse");
		Student ranga = new Student("Ranga Karanam", "Hiker, Programmer and Architect", new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));
		Student satish = new Student("Satish T", "Hiker, Programmer and Architect", new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

		List courses = Arrays.asList(
				course1,
				course2,
				course3,
				course4
		);

		Mockito.when(studentService.retrieveCourses(String.valueOf(Mockito.anyString()))).thenReturn(courses);
		ResponseEntity<List<Course>> returnedListEntity = studentController.retrieveCoursesForStudent("0");
		assertThat(returnedListEntity.getBody().size()).isEqualTo(4);
	}


}
