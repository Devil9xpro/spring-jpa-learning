package com.example.springjpalearning;
import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findByIdTest(){
		Course course = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps", course.getName());
		// fail case
		// Assertions.assertEquals("JPA in 51 steps", course.getName());
	}


}
