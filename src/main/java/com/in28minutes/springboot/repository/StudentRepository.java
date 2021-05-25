package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDescription(String description);
}
