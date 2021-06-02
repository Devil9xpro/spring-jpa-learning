package com.example.springjpalearning;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = SpringJpaLearningApplication.class)
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EntityManager em;

	@Test
	public void findByIdTest() {
		Course course = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps", course.getName());
		// fail case
		// Assertions.assertEquals("JPA in 51 steps", course.getName());
	}

	@Test
	public void findByIdJPQL() {
		// List resultList = em.createQuery("Select c From Course c").getResultList();
		// logger.info("Select c From Course c -> {}", resultList);

		TypedQuery<Course> querry = em.createQuery("Select c From Course c", Course.class);
		List<Course> rsList = querry.getResultList();
		logger.info("Select c From Course c -> {}", rsList);
	}

	@Test
	public void findByIdWhereJPQL() {
		TypedQuery<Course> querry = em.createQuery("Select c From Course c where name like '%100 steps'", Course.class);
		List<Course> rsList = querry.getResultList();
		logger.info("Select c From Course c -> {}", rsList);
	}

	@Test
	@DirtiesContext
	public void deleteByIdTest() {
		courseRepository.deleteById(10002L);
		Assertions.assertNull(courseRepository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void saveTest() {
		Course course = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps", course.getName());
		course.setName("JPA in 50 steps-Updated");
		courseRepository.save(course);
		Course courseUpdate = courseRepository.findById(10001L);
		Assertions.assertEquals("JPA in 50 steps-Updated", courseUpdate.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManagerTest() {
		courseRepository.playWithEntityManager();
	}

	@Test
	public void findAllByNamedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_course", Course.class);
		List<Course> rList = query.getResultList();
		logger.info("Select c From Course c -> {}", rList);
	}

	@Test
	public void findByNamedWhereQuery() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_steps_course", Course.class);
		List<Course> rList = query.getResultList();
		logger.info("Select c From Course c -> {}", rList);
	}

}
