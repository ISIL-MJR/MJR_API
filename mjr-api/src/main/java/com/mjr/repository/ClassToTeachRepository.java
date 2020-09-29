package com.mjr.repository;

import com.mjr.model.ClassToTeach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassToTeachRepository extends JpaRepository<ClassToTeach, Integer> {
}
