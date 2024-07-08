package com.arij.courseservice.services.interfaces;

import com.arij.courseservice.entities.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICourseService {

    List<Course> getAllCourses();
    List<Course> getCoursesByName(String courseName);
    Course getCourseById(long idCourse);
    List<Course> getAllCoursesByUserId(long idUser);
    Course addCourseToTeaacher(Course course, long idTeacher);
    MultipartFile uploadImageCourse(MultipartFile image, long idCourse) ;
    Course updateCourseById (long id);
    void deleteImageCourseById (MultipartFile image);
    String deleteCourseById(long idCourse);

}
