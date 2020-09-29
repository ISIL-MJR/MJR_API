package com.mjr.repository;

import com.mjr.model.ClassStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudentsRepository extends JpaRepository<ClassStudents, Integer> {
}
