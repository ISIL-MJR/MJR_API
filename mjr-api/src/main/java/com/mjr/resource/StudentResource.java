package com.mjr.resource;

import com.mjr.model.ClassToTeach;
import com.mjr.model.Student;
import com.mjr.service.ClassToTeachService;
import com.mjr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAll(){
        List<Student> students = studentService.getAll();
        if (students.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(students ,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity save(@RequestBody Student student) {
        studentService.create(student);
        return new ResponseEntity(student, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Student student) {

        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        student.setIdStudent(id);
        studentService.update(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        studentService.delete(currentStudent);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentStudent, HttpStatus.OK);
    }
}
