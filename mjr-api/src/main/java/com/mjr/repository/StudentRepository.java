package com.mjr.repository;

import com.mjr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT DISTINCT s.* FROM tbl_student s " +
            "INNER join tbl_classroom cr ON s.id_student = cr.id_student1 OR s.id_student = cr.id_student2 OR s.id_student = cr.id_student3 OR s.id_student = cr.id_student4 " +
            "INNER JOIN tbl_teacher t ON cr.id_teacher = t.id_teacher " +
            "WHERE t.id_teacher = ?1", nativeQuery = true)
    List<Student> getAllStudentsOfTeacher(Integer idTeacher);
    @Query(value = "SELECT DISTINCT s.* FROM tbl_student s " +
            "INNER join tbl_classroom cr ON s.id_student = cr.id_student1 OR s.id_student = cr.id_student2 OR s.id_student = cr.id_student3 OR s.id_student = cr.id_student4 " +
            "INNER JOIN tbl_teacher t ON cr.id_teacher = t.id_teacher " +
            "WHERE t.id_teacher = ?1 AND cr.id = ?2", nativeQuery = true)
    List<Student> getAllStudentsOfTeacherInClass(Integer idTeacher, Integer idClass);
}
