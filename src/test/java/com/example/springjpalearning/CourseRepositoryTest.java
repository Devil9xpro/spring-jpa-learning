package com.example.springjpalearning;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findByIdTest() {
		Course course = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps", course.getName());
		// fail case
		// Assertions.assertEquals("JPA in 51 steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteByIdTest() {
		courseRepository.deleteById(10002L);
		Assertions.assertNull(courseRepository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void saveTest(){
		Course course = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps", course.getName());
		course.setName("JPA in 50 steps-Updated");
		courseRepository.save(course);
		Course courseUpdate = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps-Updated", courseUpdate.getName());
	}

}
