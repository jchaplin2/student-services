package com.in28minutes.springboot.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.in28minutes.springboot.service.StudentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.service.StudentServiceUnitTest;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;


    @Test
    public void retrieveDetailsForCourse() throws Exception {

        Course mockCourse = new Course( Long.parseLong("1"), "Spring", "10 Steps", "Learn Maven Import Project First Example Second Example");

        Mockito.when(studentService.retrieveCourse(Mockito.anyLong(), Mockito.anyLong()))
                                    .thenReturn(mockCourse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/students/1/courses/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"name\":\"Spring\",\"description\":\"10 Steps\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void createStudentCourse() throws Exception {
        Course mockCourse = new Course(Long.parseLong("1"), "Smallest Number", "1", "1,2,3,4");

        // studentService.addCourse to respond back with mockCourse
        Mockito.when(studentService.addCourse(Mockito.anyLong(),
                        Mockito.any(Course.class))).thenReturn(mockCourse);

        String exampleCourseJson = "{\"id\":\"1\", \"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":\"Learn Maven, Import Project, First Example, Second Example\"}";

        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/students/1/courses")
                .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/api/students/1/courses/1",
                response.getHeader(HttpHeaders.LOCATION));

    }

}