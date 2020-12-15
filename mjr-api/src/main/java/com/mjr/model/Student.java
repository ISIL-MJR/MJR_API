package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;
    @Column(nullable = false, name= "first_name")
    private String firstName;
    @Column(nullable = false, name= "last_name")
    private String lastName;
    @Column(nullable = false, name= "date_of_birth")
    private Date dateOfBirth;
    @Column(nullable = false, name= "student_level")
    private String studentLevel;
    private String status;
}

