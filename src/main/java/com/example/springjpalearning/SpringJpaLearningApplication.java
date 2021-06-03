package com.example.springjpalearning;

import java.util.ArrayList;
import java.util.List;

import com.example.springjpalearning.entity.Review;
import com.example.springjpalearning.repository.CourseRepository;
import com.example.springjpalearning.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringJpaLearningApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Course course = courseRepository.findById(10001L);
		// logger.info("Course 10001 -> {}", course.toString());

		// // courseRepository.deleteById(10001L);
		// courseRepository.save(new Course("Microservices in 100 steps"));
		// courseRepository.save(new Course("Microservices in 100 steps"));

		// courseRepository.playWithEntityManager();
		// courseRepository.updateAndCreationTimeStamp();

		// studentRepository.saveStudentWithPassport();
		// studentRepository.retrieveStudentAndPassportDetails();
		// studentRepository.retrievePassportAssociatedStudent();

		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on stuff"));
        reviews.add(new Review("5", "Hatsoff"));
		courseRepository.addReviewsForCourse(10003L, reviews);
	}
	
}
