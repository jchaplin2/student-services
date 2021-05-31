insert into course(id, name, description, steps) VALUES(1, 'Spring', '10 Steps', 'Learn Maven, Import Project, First Example, Second Example');
insert into course(id, name, description, steps) VALUES(2, 'Spring MVC', '10 Examples' , 'Learn Maven, Import Project, First Example, Second Example');
insert into course(id, name, description, steps) VALUES(3, 'Spring Boot', '6K Students', 'Learn Maven, Learn Spring, Import Project, First Example, Second Example');
insert into course(id, name, description, steps) VALUES(4, 'Maven', 'Most popular maven course on internet!', 'Pom.xml, Build Life Cycle, Parent POM, Importing into Eclipse');

insert into student(id, name, description) VALUES(1, 'Ranga Karanam', 'Hiker, Programmer and Architect');
insert into student(id, name, description) VALUES(2, 'Satish T', 'Hiker, Programmer and Architect');

insert into student_courses(student_id, course_id) VALUES(1,1);
insert into student_courses(student_id, course_id) VALUES(1,2);
insert into student_courses(student_id, course_id) VALUES(1,3);
insert into student_courses(student_id, course_id) VALUES(1,4);
insert into student_courses(student_id, course_id) VALUES(2,1);
insert into student_courses(student_id, course_id) VALUES(2,2);
insert into student_courses(student_id, course_id) VALUES(2,3);
insert into student_courses(student_id, course_id) VALUES(2,4);