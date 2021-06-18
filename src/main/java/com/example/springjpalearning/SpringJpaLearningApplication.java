package com.example.springjpalearning;

import java.math.BigDecimal;

import com.example.springjpalearning.entity.FullTimeEmployee;
import com.example.springjpalearning.entity.PartTimeEmployee;
import com.example.springjpalearning.repository.CourseRepository;
import com.example.springjpalearning.repository.EmployeeRepository;
import com.example.springjpalearning.repository.StudentAndCourseManyToManyRepository;
import com.example.springjpalearning.repository.StudentRepository;

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

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentAndCourseManyToManyRepository studentAndCourseManyToManyRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

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

		// List<Review> reviews = new ArrayList<>();
		// reviews.add(new Review("5", "Great Hands-on stuff"));
		// reviews.add(new Review("5", "Hatsoff"));
		// courseRepository.addReviewsForCourse(10003L, reviews);

		// studentAndCourseManyToManyRepository.retrieveStudentAndCourse();
		// studentAndCourseManyToManyRepository.insertHardcodedStudentAndCourse();

		// studentAndCourseManyToManyRepository.insertStudentAndCourse(new
		// Student("Jack"),
		// new Course("Microservices in 100 steps"));

		// studentAndCourseManyToManyRepository.insertStudentToCourse(20001L, 10001L);

		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		// logger.info("All Employee -> {}", employeeRepository.retrieveAllEmployee());
		logger.info("All full time Employee -> {}", employeeRepository.retrieveAllFullTimeEmployee());
		logger.info("All part time Employee -> {}", employeeRepository.retrieveAllPartTimeEmployee());
	}

}
