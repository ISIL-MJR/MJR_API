package com.mjr.service;

import com.mjr.model.Teacher;
import com.mjr.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements GenericService<Teacher, Integer>{
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void changeStatus(Teacher teacher, String status){
        teacher.setStatus(status);
        teacherRepository.save(teacher);
    }

    public Teacher changeStatusById(Integer id, String status){
        Teacher foundTeacher = teacherRepository.findById(id).orElse(null);
        if (foundTeacher != null){
            foundTeacher.setStatus(status);
            teacherRepository.save(foundTeacher);
            return foundTeacher;
        }
        else return null;
    }
}
