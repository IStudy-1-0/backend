package com.arij.courseservice.repository;

import com.arij.courseservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {

    Course findCourseById(Long idCourse);
    Boolean existsCourseById(Long idCourse);
    void removeCourseById(Long idCourse);
    List <Course> findByCourseName(String courseName);
    List <Course> findCoursesByIdUser(long idUser);
}
