package com.in28minutes.springboot;

import com.in28minutes.springboot.config.H2JpaConfig;
import com.in28minutes.springboot.model.Student;
import com.in28minutes.springboot.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentServicesApplication.class, H2JpaConfig.class},
                webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,
                properties = { "integration-test.findOnly = true" })
@ActiveProfiles("it")
public class FindRecordsIntegrationTest {

    @Autowired
    StudentRepository studentRepository;


    @Test
    public void test_find(){
        Student foundStudent = studentRepository.findById(new Long(1)).orElse(null);
        assertNotNull(foundStudent);
    }

}
