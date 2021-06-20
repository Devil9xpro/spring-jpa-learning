package com.example.springjpalearning;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseSpringDataRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
public class CachingJPA {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseSpringDataRepository repository;

    @Test
    @Transactional
    public void findById_firstLevelCacheDemo() {
        Optional<Course> course = repository.findById(10001L);
        logger.info(course.get().getName());
        logger.info("First Course Retrieved -> {}", course);
        Optional<Course> course1 = repository.findById(10001L);
        logger.info("First Course Trieved again -> {}", course1);
    }
}
