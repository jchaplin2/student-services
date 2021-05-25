package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceUnitTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void test_retrieveCourses() throws Exception {
        Course course1 = new Course("Spring", "10 Steps", "Learn Maven Import Project First Example Second Example");
        Course course2 = new Course( "Spring MVC", "10 Examples", "Learn Maven Import Project First Example Second Example");
        Course course3 = new Course("Spring Boot", "6K Students", "Learn Maven Learn Spring Learn Spring MVC First Example Second Example");
        Course course4 = new Course("Maven", "Most popular maven course on internet!", "Pom.xml Build Life Cycle Parent POM Importing into Eclipse");
        Student ranga = new Student("Ranga Karanam", "Hiker, Programmer and Architect", new ArrayList<>(Arrays.asList(course1, course2, course3, course4)));

//        List students = Arrays.asList(ranga, satish);
//        Mockito.when(studentService.retrieveCourses(String.valueOf(Mockito.anyLong()))).thenReturn(
//                students
//        );
        Mockito.when(studentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ranga));
//        Optional<Student> optionalStudent = studentRepository.findById(new Long(1));
//        Student student = optionalStudent.get();

//        Mockito.when(student.getCourses()).thenReturn(Arrays.asList(
//                course1,
//                course2,
//                course3,
//                course4
//        ));

        List returnedList = studentService.retrieveCourses("1");
        assertThat(returnedList.size()).isEqualTo(4);
    }

}
