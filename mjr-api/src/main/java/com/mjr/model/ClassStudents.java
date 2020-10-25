package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Student> students;

    public void addStudents(List<Student> studentList) {
        students = new ArrayList<>();
        for (Student s : studentList) {
            s.setClassStudents(this);
            this.students.add(s);
        }
    }

    @Override
    public String toString() {
        return "ClassStudents{" +
                "idClassStudent=" + idClassStudent +
                ", isGroupClass=" + isGroupClass +
                ", nameGroupClass='" + nameGroupClass + '\'' +
                '}';
    }
}
