package com.mjr.resource;

import com.mjr.model.ClassToTeach;
import com.mjr.service.ClassToTeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassToTeachResource {
    @Autowired
    ClassToTeachService classToTeachService;

    @GetMapping("/class-to-teach")
    public ResponseEntity getAll(){
        List<ClassToTeach> classToTeaches = classToTeachService.getAll();
        if (classToTeaches.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classToTeaches ,HttpStatus.OK);
    }

    @PostMapping("/class-to-teach")
    public ResponseEntity save(@RequestBody ClassToTeach classToTeach) {
        classToTeachService.create(classToTeach);
        return new ResponseEntity(classToTeach, HttpStatus.CREATED);
    }

    @PutMapping("/class-to-teach/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody ClassToTeach classToTeach) {

        ClassToTeach currentClassToTeach = classToTeachService.findById(id);
        if (currentClassToTeach == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classToTeach.setIdClass(id);
        classToTeachService.update(classToTeach);
        return new ResponseEntity(classToTeach, HttpStatus.OK);
    }

    @DeleteMapping("/class-to-teach/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        ClassToTeach currentClassToTeach = classToTeachService.findById(id);
        if (currentClassToTeach == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classToTeachService.delete(currentClassToTeach);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/class-to-teach/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        ClassToTeach currentClassToTeach = classToTeachService.findById(id);
        if (currentClassToTeach == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentClassToTeach, HttpStatus.OK);
    }

    @GetMapping("/class-to-teach/by-teacher-range/{id}&{min}&{max}")
    public ResponseEntity getAllByTeacherAndDateRange(@PathVariable Integer id, @PathVariable String min, @PathVariable String max){
        List<ClassToTeach> classToTeaches = classToTeachService.getAllClassesOfTeacherInDateRange(id, Date.valueOf(min), Date.valueOf(max));
        if (classToTeaches.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classToTeaches ,HttpStatus.OK);
    }

    @GetMapping("/class-to-teach/by-teacher-today/{id}")
    public ResponseEntity getAllByTeacherToday(@PathVariable Integer id){
        List<ClassToTeach> classToTeaches = classToTeachService.getAllClassesOfTeacherInThisDay(id);
        if (classToTeaches.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classToTeaches ,HttpStatus.OK);
    }

    @GetMapping("/class-to-teach/by-teacher-week/{id}")
    public ResponseEntity getAllByTeacherThisWeek(@PathVariable Integer id){
        List<ClassToTeach> classToTeaches = classToTeachService.getAllClassesOfTeacherInThisWeek(id);
        if (classToTeaches.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classToTeaches ,HttpStatus.OK);
    }

    @GetMapping("/class-to-teach/by-teacher-month/{id}")
    public ResponseEntity getAllByTeacherThisMonth(@PathVariable Integer id){
        List<ClassToTeach> classToTeaches = classToTeachService.getAllClassesOfTeacherInThisMonth(id);
        if (classToTeaches.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classToTeaches ,HttpStatus.OK);
    }
}
