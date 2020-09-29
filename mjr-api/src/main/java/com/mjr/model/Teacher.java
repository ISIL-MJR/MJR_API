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
    @Column(name = "id_teacher")
    private Integer idTeacher;
    @Column(nullable = false, name= "first_name")
    private String firstName;
    @Column(nullable = false, name= "last_name")
    private String lastName;
    @Column(nullable = false, name= "date_of_birth")
    private Date dateOfBirth;
    @Column(nullable = false, name= "document_type")
    private String documentType;
    @Column(nullable = false, name= "document_number")
    private String documentNumber;
    @Column(nullable = false, name= "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
