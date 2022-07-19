package by.academy.it.task12.dao.impl;

import by.academy.it.task12.dao.StudentDao;
import by.academy.it.task12.entity.Student;

import javax.persistence.EntityManager;

public class StudentDaoImpl extends EntityDaoImpl<Student> implements StudentDao {
    public StudentDaoImpl(EntityManager em) {
        super(em, Student.class);
    }
}
