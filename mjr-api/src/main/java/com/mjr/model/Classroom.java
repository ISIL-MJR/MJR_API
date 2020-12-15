package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_classroom")
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date date;
    private String status;
    private Long startTime;
    private Long endTime;
    @OneToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "id_student1")
    private Student student1;
    @OneToOne
    @JoinColumn(name = "id_student2")
    private Student student2;
    @OneToOne
    @JoinColumn(name = "id_student3")
    private Student student3;
    @OneToOne
    @JoinColumn(name = "id_student4")
    private Student student4;
}
