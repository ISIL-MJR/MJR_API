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
    @Test
    void tryGetClassesByTeacherAndDateRage(){
        System.out.print(classToTeachRepository.getAllClassesByTeacherAndDate(1, java.sql.Date.valueOf("1999-09-09"), java.sql.Date.valueOf("2021-07-09")));
    }
}
