package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_class_students")
@Entity
public class ClassStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassStudent;
    @Column(nullable = false)
    private Boolean isGroupClass;
    @Column(nullable = true)
    private String nameGroupClass;
    @Column(nullable = false)
    private List<Student> studentList;
}
