INSERT INTO tbl_teacher (first_name, last_name, date_of_birth, document_type, document_number, phone_number, email, password)
VALUES
       ("Patrick", "Mahomes", "1997-11-19", "DNI", "11111111","555-555-5555","email@email.com", "1234" ),
       ('Tony', 'Stark', '1990-11-19', 'DNI', '11111111','555-321-5391', 'nottheavenger@email.com', '1234' ),
       ('Andy', 'Reid', '1980-1-19', 'CE', '222222222','555-123-4567', 'totallyreal@email.com', '1234' ),
       ('Bob', 'Teacher', '1990-4-1', 'DNI', '33333333','555-573-1122', 'whyismylastnameteacher@email.com', '1234' )

INSERT INTO tbl_class_students (id_class_student, is_group_class, name_group_class)
VALUES
        (1,TRUE,'Dolphins'),
        (2,false, null),
        (3,TRUE,'Monkeys'),
        (4,TRUE,'Penguins'),
        (5,false, null),
        (6,false, null);

INSERT INTO tbl_student (first_name, last_name, date_of_birth, student_level, id_class_student)
VALUES
        ('Billy', 'Bobson', '2001-4-1', 'Intermediate', 1),
        ('Augustina', 'Noviembre', '2001-7-11', 'Intermediate', 1),
        ('Richard', 'Nixon', '2002-1-1', 'Intermediate', 1),
        ('Jorge', 'Moliner', '1990-12-13', 'Advanced', 2),
        ('George', 'Nameson', '2010-4-1', 'Basic', 3),
        ('Phillip', 'Cajas', '2011-1-12', 'Basic', 3),
        ('Annie', 'Areyouokay', '2005-6-1', 'Intermediate', 4),
        ('Ricardo', 'Notfake', '2005-1-11', 'Intermediate', 4),
        ('Maria', 'Salazar', '2001-4-1', 'Intermediate', 5),
        ('George', 'Nameson', '1996-4-1', 'Advanced', 6);

INSERT INTO tbl_class_to_teach (class_date, id_class_student, id_teacher)
VALUES
        ('2020-10-22 16:00:00', 1, 1),
        ('2020-10-27 16:00:00', 1, 1),
        ('2020-10-29 16:00:00', 1, 1),

        ('2020-10-23 16:00:00', 2, 2),
        ('2020-10-26 16:00:00', 2, 2),
        ('2020-10-28 16:00:00', 2, 2),
        ('2020-10-30 16:00:00', 2, 2),

        ('2020-10-22 16:00:00', 3, 3),
        ('2020-10-27 16:00:00', 3, 3),
        ('2020-10-29 16:00:00', 3, 3),

        ('2020-10-22 17:00:00', 4, 1),
        ('2020-10-27 17:00:00', 4, 1),
        ('2020-10-29 17:00:00', 4, 1),

        ('2020-10-23 16:00:00', 5, 3),
        ('2020-10-27 17:00:00', 5, 3),
        ('2020-10-29 17:00:00', 5, 3),

        ('2020-10-23 17:00:00', 6, 2),
        ('2020-10-27 17:00:00', 6, 2),
        ('2020-10-29 17:00:00', 6, 2);




