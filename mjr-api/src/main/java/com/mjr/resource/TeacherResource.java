package com.mjr.resource;

import com.mjr.model.Student;
import com.mjr.model.Teacher;
import com.mjr.service.StudentService;
import com.mjr.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherResource {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity getAll(){
        List<Teacher> teachers = teacherService.getAll();
        if (teachers.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(teachers ,HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity save(@RequestBody Teacher teacher) {
        teacherService.create(teacher);
        return new ResponseEntity(teacher, HttpStatus.CREATED);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Teacher teacher) {

        Teacher currentTeacher = teacherService.findById(id);
        if (currentTeacher == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        teacher.setIdTeacher(id);
        teacherService.update(teacher);
        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Teacher currentTeacher = teacherService.findById(id);
        if (currentTeacher == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        teacherService.delete(currentTeacher);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Teacher currentTeacher = teacherService.findById(id);
        if (currentTeacher == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentTeacher, HttpStatus.OK);
    }
}
