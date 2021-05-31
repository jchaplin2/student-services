CREATE USER IF NOT EXISTS SA SALT 'e6407c866383f99a' HASH 'e308ce43d21209edd711bc581962406f2bd716f80c026f6d72650d94b99c3eb0' ADMIN;
CREATE SEQUENCE PUBLIC.HIBERNATE_SEQUENCE START WITH 1;
CREATE MEMORY TABLE PUBLIC.COURSE(
    ID BIGINT NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    STEPS VARCHAR(255) NOT NULL
);
ALTER TABLE PUBLIC.COURSE ADD CONSTRAINT PUBLIC.CONSTRAINT_7 PRIMARY KEY(ID);

CREATE MEMORY TABLE PUBLIC.STUDENT(
    ID BIGINT NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL
);
ALTER TABLE PUBLIC.STUDENT ADD CONSTRAINT PUBLIC.CONSTRAINT_B PRIMARY KEY(ID);


CREATE MEMORY TABLE PUBLIC.STUDENT_COURSES(
    STUDENT_ID BIGINT NOT NULL,
    COURSE_ID BIGINT NOT NULL
);
ALTER TABLE PUBLIC.STUDENT_COURSES ADD CONSTRAINT PUBLIC.UKBT7WYKV7C5NIHOXYA86JSU58F UNIQUE(STUDENT_ID, COURSE_ID);
ALTER TABLE PUBLIC.STUDENT_COURSES ADD CONSTRAINT PUBLIC.FKIQUFQWGB6IM4N8XSLHJVXMT0N FOREIGN KEY(STUDENT_ID) REFERENCES PUBLIC.STUDENT(ID) NOCHECK;
ALTER TABLE PUBLIC.STUDENT_COURSES ADD CONSTRAINT PUBLIC.FKC614IN0KDHJ9SIH7VW304QXGJ FOREIGN KEY(COURSE_ID) REFERENCES PUBLIC.COURSE(ID) NOCHECK;