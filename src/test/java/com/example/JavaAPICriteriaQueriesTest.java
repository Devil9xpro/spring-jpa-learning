package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.springjpalearning.SpringJpaLearningApplication;
import com.example.springjpalearning.entity.Course;
import com.jayway.jsonpath.Criteria;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class JavaAPICriteriaQueriesTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void basicQuery() {
        // Select c from Course c

        // 1. Use Criteria Builder to create a Criteria Query returning the expected
        // result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define root for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3. Define predicate etc using criteria builder
        // 4. Add predicate etc to the criteria query
        // 5. Build the TypedQuery using entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_course_having_100steps() {
        // select c from Course c where name like '%100 steps'
        // 1
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2
        Root<Course> courseRoot = cq.from(Course.class);
        // 3
        Predicate like100steps = cb.like(courseRoot.get("name"), "%100 steps");
        // 4
        cq.where(like100steps);
        // 5
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_course_without_student() {
        // select c from Course c where c.student is empty
        // 1
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2
        Root<Course> courseRoot = cq.from(Course.class);
        // 3
        Predicate studentIsEmpty = cb.isEmpty(courseRoot.get("students"));
        // 4
        cq.where(studentIsEmpty);
        // 5
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void join() {
        // select c from Course c join c.students s
        // 1
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2
        Root<Course> courseRoot = cq.from(Course.class);
        // 3
        Join<Object, Object> join = courseRoot.join("students");
        // 4
        // 5
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void left_join() {
        // select c from Course c join c.students s
        // 1
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2
        Root<Course> courseRoot = cq.from(Course.class);
        // 3
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
        // 4
        // 5
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }
}
