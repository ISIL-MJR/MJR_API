package com.mjr.service;

import com.mjr.model.ClassToTeach;
import com.mjr.repository.ClassToTeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
