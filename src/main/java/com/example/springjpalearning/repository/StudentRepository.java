package com.example.springjpalearning.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Passport;
import com.example.springjpalearning.entity.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("student's passport -> {}", student.getPassport());
    }

    //bidirectional
    public void retrievePassportAssociatedStudent(){
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

}
