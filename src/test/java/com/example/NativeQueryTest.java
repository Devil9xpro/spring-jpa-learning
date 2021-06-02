package com.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.example.springjpalearning.SpringJpaLearningApplication;
import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class NativeQueryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        var rsList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}", rsList);
    }

    @Test
    public void native_queries_basic_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE where id =?", Course.class);
        query.setParameter(1, 10001L);
        var rsList = query.getResultList();
        logger.info("SELECT * FROM COURSE where id =? -> {}", rsList);
    }

    @Test
    public void native_queries_basic_with_named_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
        query.setParameter("id", 10001L);
        var rsList = query.getResultList();
        logger.info("SELECT * FROM COURSE where id =? -> {}", rsList);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("Update COURSE set last_updated_date=sysdate()", Course.class);
        int noRowUpdated = query.executeUpdate();
        logger.info("noRowUpdated -> {}", noRowUpdated);
    }
}
