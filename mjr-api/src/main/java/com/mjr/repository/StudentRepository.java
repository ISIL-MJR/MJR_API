package com.mjr.repository;

import com.mjr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT DISTINCT s.* FROM tbl_student s " +
            "INNER join tbl_class_students cs ON s.id_class_student = cs.id_class_student " +
            "INNER join tbl_class_to_teach ct ON cs.id_class_student = ct.id_class_student " +
            "INNER join tbl_teacher t ON ct.id_teacher = t.id_teacher " +
            "WHERE t.id_teacher = ?1", nativeQuery = true)
    List<Student> getAllStudentsOfTeacher(Integer idTeacher);
    @Query(value = "SELECT DISTINCT s.* FROM tbl_student s " +
            "INNER join tbl_class_students cs ON s.id_class_student = cs.id_class_student " +
            "INNER join tbl_class_to_teach ct ON cs.id_class_student = ct.id_class_student " +
            "INNER join tbl_teacher t ON ct.id_teacher = t.id_teacher " +
            "WHERE t.id_teacher = ?1 AND ct.id_class_student = ?2", nativeQuery = true)
    List<Student> getAllStudentsOfTeacherInClass(Integer idTeacher, Integer idClass);
}
