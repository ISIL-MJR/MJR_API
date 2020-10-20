package com.mjr;

import com.mjr.model.ClassStudents;
import com.mjr.model.ClassToTeach;
import com.mjr.model.Teacher;
import com.mjr.repository.ClassStudentsRepository;
import com.mjr.repository.ClassToTeachRepository;
import com.mjr.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
public class ClassesRepositoryTests {
    @Autowired
    ClassToTeachRepository classToTeachRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ClassStudentsRepository classStudentsRepository;

    @Test
    void tryout(){
        Teacher teacher = new Teacher();
        teacher.setDateOfBirth(Date.from(Instant.now()));
        teacher.setDocumentNumber("111");
        teacher.setDocumentType("tt");
        teacher.setEmail("111");
        teacher.setPassword("44");
        teacher.setPhoneNumber("555");
        teacher.setFirstName("Juan");
        teacher.setLastName("One");

        ClassStudents classStudents = new ClassStudents();
        classStudents.setIsGroupClass(true);
        classStudents.setNameGroupClass("Tests");

        ClassToTeach classToTeach = new ClassToTeach();
        classToTeach.setTeacher(teacher);
        classToTeach.setClassStudents(classStudents);
        classToTeach.setClassDate(java.sql.Date.valueOf(LocalDate.now()));

        classStudentsRepository.save(classStudents);
        teacherRepository.save(teacher);
        classToTeachRepository.save(classToTeach);

        System.out.print(classToTeachRepository.getAllClassesByTeacherAndDate(1, java.sql.Date.valueOf(LocalDate.MIN), java.sql.Date.valueOf(LocalDate.MAX)));
    }
}
