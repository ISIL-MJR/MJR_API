package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_class_to_teach")
@Entity
public class ClassToTeach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClass;
    @Column(nullable = false)
    private Date classDate;

    @OneToOne
    @JoinColumn(name="tbl_teacher", referencedColumnName="id_teacher")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name="tbl_class_students", referencedColumnName="id_class_student")
    private ClassStudents classStudents;
}
