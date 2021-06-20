package com.example.springjpalearning.repository;

import java.util.List;

import com.example.springjpalearning.entity.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    List<Course> findByNameAndId(String name, Long id);

    List<Course> countByName(String name);

    List<Course> findByNameOrderByIdDesc(String name);

    List<Course> deleteByName(String name);

    @Query("Select c from Course c where name like '%100 steps'")
    List<Course> courseWith100stepsInName();

    @Query(value = "Select c from Course c where name like '%100 steps'", nativeQuery = true)
    List<Course> courseWith100stepsInNameNativeQuery();

    @Query(name = "query_get_100_steps_course")
    List<Course> courseWith100stepsInNameNamedQuery();
}
