package com.example.springjpalearning;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Address;
import com.example.springjpalearning.entity.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void setAdressDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        student.setAddress(new Address("line1", "line2", "city"));
        entityManager.flush();
        logger.info("student -> {}", student.toString());
    }
}
