package com.mjr.service;

import com.mjr.model.ClassStudents;
import com.mjr.repository.ClassStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentsService implements GenericService<ClassStudents, Integer>{
    @Autowired
    ClassStudentsRepository classStudentsRepository;

    @Override
    public List<ClassStudents> getAll() {
        return classStudentsRepository.findAll();
    }

    @Override
    public void create(ClassStudents classStudents) {
        classStudentsRepository.save(classStudents);
    }

    @Override
    public void update(ClassStudents classStudents) {
        classStudentsRepository.save(classStudents);
    }

    @Override
    public void delete(ClassStudents classStudents) {
        classStudentsRepository.delete(classStudents);
    }

    @Override
    public ClassStudents findById(Integer id) {
        return classStudentsRepository.findById(id).orElse(null);
    }
}
