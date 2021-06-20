package com.example.springjpalearning.repository;

import com.example.springjpalearning.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    
}
