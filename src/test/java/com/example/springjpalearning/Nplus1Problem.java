package com.example.springjpalearning;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Course;

import org.hibernate.engine.config.internal.ConfigurationServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class Nplus1Problem {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void solvingNPlus1Problem_EntityGraph() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        Subgraph<Object> subgraph = entityGraph.addSubgraph("students");
        List<Course> courses = em.createNamedQuery("query_get_all_course", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph).getResultList();
        for (Course course : courses) {
            logger.info("Course -> {}, Student -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void solvingNPlus1Problem_JoinFetch() {
        List<Course> courses = em.createNamedQuery("query_get_all_course_join_fetch", Course.class).getResultList();
        for (Course course : courses) {
            logger.info("Course -> {}, Student -> {}", course, course.getStudents());
        }
    }

}
