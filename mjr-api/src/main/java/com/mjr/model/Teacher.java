package com.mjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_teacher")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeacher;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String documentType;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private String password;
}
