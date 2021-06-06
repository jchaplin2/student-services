package com.in28minutes.springboot;

import com.in28minutes.springboot.config.H2JpaConfig;
import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.repository.StudentRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentServicesApplication.class, H2JpaConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "integration-test.findOnly = false" })
@ActiveProfiles("it")
public class SaveAndFindRecordsIntegrationTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test_saveAndFind(){
        Course course1 = new Course("Spring", "10 Steps", "Learn Maven Import Project First Example Second Example");
        Student student = studentRepository.save(new Student("John Smith", "A student.", Arrays.asList(course1)));
        Student foundStudent = studentRepository.findById(student.getId()).orElse(null);

        assertNotNull(foundStudent);
    }
}
