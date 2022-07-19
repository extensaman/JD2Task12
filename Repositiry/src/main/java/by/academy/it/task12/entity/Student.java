package by.academy.it.task12.entity;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Student implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String surname;

    @Column(length = 40)
    private String name;

    @Column(length = 45)
    private String patronymic;

    @Column(length = 30, name = "studying_group")
    private String group;

    @Column(name = "date_of_birth")
    private Calendar dateOfBirth;
}
