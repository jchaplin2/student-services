package com.in28minutes.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name ="student_courses",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"),
			uniqueConstraints = {@UniqueConstraint(columnNames={"student_id", "course_id"})}
	)
	private List<Course> courses;

	public Student(){

	}

	public Student(String name, String description, List<Course> courses) {
		super();
		this.name = name;
		this.description = description;
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [id=%s, name=%s, description=%s, courses=%s]", id,
				name, description, courses);
	}
}