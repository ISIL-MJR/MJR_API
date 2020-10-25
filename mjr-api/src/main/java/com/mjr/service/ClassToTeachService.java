package com.mjr.service;

import com.mjr.model.ClassToTeach;
import com.mjr.repository.ClassToTeachRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.*;

@Service
public class ClassToTeachService implements GenericService<ClassToTeach, Integer>{
    @Autowired
    ClassToTeachRepository classToTeachRepository;

    @Override
    public List<ClassToTeach> getAll() {
        return classToTeachRepository.findAll();
    }

    @Override
    public void create(ClassToTeach classToTeach) {
        classToTeachRepository.save(classToTeach);
    }

    @Override
    public void update(ClassToTeach classToTeach) {
        classToTeachRepository.save(classToTeach);
    }

    @Override
    public void delete(ClassToTeach classToTeach) {
        classToTeachRepository.delete(classToTeach);
    }

    @Override
    public ClassToTeach findById(Integer id) {
        return classToTeachRepository.findById(id).orElse(null);
    }

    public List<ClassToTeach> getAllClassesOfTeacherInDateRange(Integer idTeacher, Date minDate, Date maxDate){
        return classToTeachRepository.getAllClassesByTeacherAndDate(idTeacher, minDate, maxDate);
    }

    public List<ClassToTeach> getAllClassesOfTeacherInThisDay(Integer idTeacher){
        LocalDate today = LocalDate.now();
        return classToTeachRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(today), Date.valueOf(today));
    }

    public List<ClassToTeach> getAllClassesOfTeacherInThisWeek(Integer idTeacher){
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);
        return classToTeachRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(startOfWeek), Date.valueOf(endOfWeek));
    }

    public List<ClassToTeach> getAllClassesOfTeacherInThisMonth(Integer idTeacher){
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        LocalDate endOfMonth = today.with(lastDayOfMonth());
        return classToTeachRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(startOfMonth), Date.valueOf(endOfMonth));
    }
}
