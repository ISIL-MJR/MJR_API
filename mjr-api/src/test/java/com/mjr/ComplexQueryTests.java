package com.mjr;

import com.mjr.repository.ClassToTeachRepository;
import com.mjr.repository.StudentRepository;
import com.mjr.service.ClassToTeachService;
import com.mjr.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class ComplexQueryTests {
    @Autowired
    ClassToTeachRepository classToTeachRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassToTeachService classToTeachService;
    @Autowired
    StudentService studentService;
    @Test
    void tryGetClassesByTeacherAndDateRage(){
        System.out.print(classToTeachRepository.getAllClassesByTeacherAndDate(1, Date.valueOf("1999-09-09"), Date.valueOf("2021-07-09")));
    }

    @Test
    void tryGetStudentsOfTeacher(){
        System.out.println(studentRepository.getAllStudentsOfTeacher(1));
    }

    @Test
    void tryOutServices(){
        System.out.println("Date Range ->" + classToTeachService.getAllClassesOfTeacherInDateRange(1, Date.valueOf("1999-05-06"), Date.valueOf("2021-06-07")));
        System.out.println("Today -> " + classToTeachService.getAllClassesOfTeacherInThisDay(1));
        System.out.println("This Week -> " + classToTeachService.getAllClassesOfTeacherInThisWeek(1));
        System.out.println("This Month -> " + classToTeachService.getAllClassesOfTeacherInThisMonth(1));
    }
}
