package com.mjr.service;

import com.mjr.model.Classroom;
import com.mjr.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Service
public class ClassroomService implements GenericService<Classroom, Integer>{
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public void create(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public void update(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public void delete(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    @Override
    public Classroom findById(Integer id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public List<Classroom> getAllClassesOfTeacherInDateRange(Integer idTeacher, Date minDate, Date maxDate){
        return classroomRepository.getAllClassesByTeacherAndDate(idTeacher, minDate, maxDate);
    }

    public List<Classroom> getAllClassesOfTeacherInThisDay(Integer idTeacher){
        LocalDate today = LocalDate.now();
        return classroomRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(today), Date.valueOf(today));
    }

    public List<Classroom> getAllClassesOfTeacherInThisWeek(Integer idTeacher){
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);
        return classroomRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(startOfWeek), Date.valueOf(endOfWeek));
    }

    public List<Classroom> getAllClassesOfTeacherInThisMonth(Integer idTeacher){
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        LocalDate endOfMonth = today.with(lastDayOfMonth());
        return classroomRepository.getAllClassesByTeacherAndDate(idTeacher, Date.valueOf(startOfMonth), Date.valueOf(endOfMonth));
    }
}
