package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByDescription(String description);

}
