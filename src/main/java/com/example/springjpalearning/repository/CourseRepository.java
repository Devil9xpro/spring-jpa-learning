package com.example.springjpalearning.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.springjpalearning.entity.Course;
import com.example.springjpalearning.entity.Review;
import com.example.springjpalearning.entity.ReviewRating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            // insert
            em.persist(course);
        } else {
            // update
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);
        Course course2 = new Course("AngularJs in 100 steps");
        em.persist(course2);
        // changes are send to db
        em.flush();

        // course2 is no longer tracked by entityManager so set method will not update
        // to db
        // em.detach(course2);
        // track nothing
        // em.clear();
        course1.setName("Web Services in 100 steps - Updated");
        course2.setName("AngularJs in 100 steps - Updated");

        // does not apply the change in course1
        em.refresh(course1);
        em.flush();
    }

    public void updateAndCreationTimeStamp() {
        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);

        Course course2 = findById(10001L);
        course2.setName("JPA in 50 steps - Updated");
    }

    public void addHardCodedReviewsForCourse() {
        // get the course
        Course course = findById(10003L);
        logger.info("course.getReviews -> {}", course.getReviews());
        // add 2 reviews to course
        Review review1 = new Review("Great Hands-on stuff", ReviewRating.FIVE);
        Review review2 = new Review("Hatsoff", ReviewRating.FIVE);
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        // save reviews to db
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews -> {}", course.getReviews());

        for (Review review : reviews) {
            // setting the relationship
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }

}
