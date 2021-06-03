package com.example.springjpalearning.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.entity.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentAndCourseManyToManyRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public void retrieveStudentAndCourse() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("course -> {}", student.getCourses());
    }

    public void insertHardcodedStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("Microservice in 100 steps");
        em.persist(student);
        em.persist(course);

        student.addCourses(course);
        course.addStudent(student);
        // persist the owning side
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        student.addCourses(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }

    public void insertStudentToCourse(Long studentId, Long courseId) {
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);
        course.addStudent(student);
        em.merge(course);
    }
}