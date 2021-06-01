package com.example.springjpalearning;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.repository.CourseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringJpaLearningApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", course.toString());

		// courseRepository.deleteById(10001L);
		courseRepository.save(new Course("Microservices in 100 steps"));
		courseRepository.save(new Course("Microservices in 100 steps"));
	}
	
}
