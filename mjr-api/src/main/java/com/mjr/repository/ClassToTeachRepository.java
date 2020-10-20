package com.mjr.repository;

import com.mjr.model.ClassToTeach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ClassToTeachRepository extends JpaRepository<ClassToTeach, Integer> {
    @Query(value = "SELECT * FROM tbl_class_to_teach WHERE id_teacher = ?1 AND class_date >= ?2 AND class_date <= ?3", nativeQuery = true)
    List<ClassToTeach> getAllClassesByTeacherAndDate(Integer idTeacher, Date minDate, Date maxDate);
}
