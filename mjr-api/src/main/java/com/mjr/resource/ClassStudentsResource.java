package com.mjr.resource;

import com.mjr.model.ClassStudents;
import com.mjr.service.ClassStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassStudentsResource {
    @Autowired
    ClassStudentsService classStudentsService;

    @GetMapping("/class-students")
    public ResponseEntity getAll(){
        List<ClassStudents> classStudents = classStudentsService.getAll();
        if (classStudents.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classStudents ,HttpStatus.OK);
    }

    @PostMapping("/class-students")
    public ResponseEntity save(@RequestBody ClassStudents classStudents) {
        classStudentsService.create(classStudents);
        return new ResponseEntity(classStudents, HttpStatus.CREATED);
    }

    @PutMapping("/class-students/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody ClassStudents classStudents) {

        ClassStudents currentClassStudents = classStudentsService.findById(id);
        if (currentClassStudents == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classStudents.setIdClassStudent(id);
        classStudentsService.update(classStudents);
        return new ResponseEntity(classStudents, HttpStatus.OK);
    }

    @DeleteMapping("/class-students/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        ClassStudents currentClassStudents = classStudentsService.findById(id);
        if (currentClassStudents == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classStudentsService.delete(currentClassStudents);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/class-students/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        ClassStudents currentClassStudents = classStudentsService.findById(id);
        if (currentClassStudents == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentClassStudents, HttpStatus.OK);
    }
}
