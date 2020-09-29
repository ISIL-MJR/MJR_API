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
    @Column(name = "id_class_student")
    private Integer idClassStudent;
    @Column(nullable = false, name = "is_group_class")
    private Boolean isGroupClass;
    @Column(nullable = true, name = "name_group_class")
    private String nameGroupClass;

    @OneToMany(mappedBy = "classStudents", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> studentList;
}
