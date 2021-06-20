package com.example.springjpalearning;

import java.util.Optional;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseSpringDataRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class CourseSpringDataRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> course = repository.findById(10001L);
        logger.info("Course -> {}", course.toString());
        logger.info("{}", course.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> course = repository.findById(20001L);
        logger.info("{}", course.isPresent());
    }

    @Test
    public void crudRepository() {
        Course course = new Course("Microservices in 100 steps");
        repository.save(course);
        course.setName("Micoservice in 100 steps - Updated");
        repository.save(course);

        logger.info("Courses -> {}", repository.findAll());
        logger.info("Count -> {}", repository.count());
    }
}
