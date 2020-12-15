package com.mjr.repository;

import com.mjr.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    @Query(value = "SELECT cr.* FROM tbl_classroom cr " +
            "WHERE cr.id_teacher = ?1 AND cr.date >= ?2 AND cr.date <= ?3", nativeQuery = true)
    List<Classroom> getAllClassesByTeacherAndDate(Integer idTeacher, Date minDate, Date maxDate);
}
