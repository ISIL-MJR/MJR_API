package com.mjr.resource;

import com.mjr.model.Classroom;
import com.mjr.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassroomResource {
    @Autowired
    ClassroomService classroomService;

    @GetMapping("/classrooms")
    public ResponseEntity getAll(){
        List<Classroom> classrooms = classroomService.getAll();
        if (classrooms.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classrooms ,HttpStatus.OK);
    }

    @PostMapping("/classrooms")
    public ResponseEntity save(@RequestBody Classroom classroom) {
        classroomService.create(classroom);
        return new ResponseEntity(classroom, HttpStatus.CREATED);
    }

    @PutMapping("/classrooms/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Classroom classroom) {

        Classroom currentClassroom = classroomService.findById(id);
        if (currentClassroom == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classroom.setId(id);
        classroomService.update(classroom);
        return new ResponseEntity(classroom, HttpStatus.OK);
    }

    @DeleteMapping("/classrooms/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Classroom currentClassroom = classroomService.findById(id);
        if (currentClassroom == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        classroomService.delete(currentClassroom);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/classrooms/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Classroom currentClassroom = classroomService.findById(id);
        if (currentClassroom == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentClassroom, HttpStatus.OK);
    }

    @GetMapping("/classrooms/by-teacher-range/{id}&{min}&{max}")
    public ResponseEntity getAllByTeacherAndDateRange(@PathVariable Integer id, @PathVariable String min, @PathVariable String max){
        List<Classroom> classrooms = classroomService.getAllClassesOfTeacherInDateRange(id, Date.valueOf(min), Date.valueOf(max));
        if (classrooms.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classrooms ,HttpStatus.OK);
    }

    @GetMapping("/classrooms/by-teacher-today/{id}")
    public ResponseEntity getAllByTeacherToday(@PathVariable Integer id){
        List<Classroom> classrooms = classroomService.getAllClassesOfTeacherInThisDay(id);
        if (classrooms.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classrooms ,HttpStatus.OK);
    }

    @GetMapping("/classrooms/by-teacher-week/{id}")
    public ResponseEntity getAllByTeacherThisWeek(@PathVariable Integer id){
        List<Classroom> classrooms = classroomService.getAllClassesOfTeacherInThisWeek(id);
        if (classrooms.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classrooms ,HttpStatus.OK);
    }

    @GetMapping("/classrooms/by-teacher-month/{id}")
    public ResponseEntity getAllByTeacherThisMonth(@PathVariable Integer id){
        List<Classroom> classrooms = classroomService.getAllClassesOfTeacherInThisMonth(id);
        if (classrooms.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(classrooms ,HttpStatus.OK);
    }
}
