package com.mjr;

import com.mjr.repository.ClassToTeachRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class ClassesRepositoryTests {
    @Autowired
    ClassToTeachRepository classToTeachRepository;
    @Test
    void tryGetClassesByTeacherAndDateRage(){
        System.out.print(classToTeachRepository.getAllClassesByTeacherAndDate(1, Date.valueOf("1999-09-09"), Date.valueOf("2021-07-09")));
    }
}
