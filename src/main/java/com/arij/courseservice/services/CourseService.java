package com.arij.courseservice.services;

import com.arij.courseservice.entities.Course;
import com.arij.courseservice.repository.ICourseRepo;
import com.arij.courseservice.services.interfaces.ICourseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    ICourseRepo courseRepo;

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<Course> getCoursesByName(String courseName) {
        List<Course> courselist = new ArrayList<>();
        courselist = courseRepo.findByCourseName(courseName);
        return courselist;
    }

    @Override
    public Course getCourseById(long idCourse) {
        return courseRepo.findCourseById(idCourse);
    }

    @Override
    public List<Course> getAllCoursesByUserId(long idTeacher) {
        return courseRepo.findCoursesByIdUser(idTeacher);
    }


    @Override
    public Course addCourseToTeaacher(Course course, long idTeacher) {
        return null;
    }

    @Override
    public MultipartFile uploadImageCourse(MultipartFile image, long idCourse) {
        return null;
    }

    @Override
    public Course updateCourseById(long id) {
        return null;
    }

    @Override
    public void deleteImageCourseById(MultipartFile image) {

    }
    @Transactional
    @Override
    public String deleteCourseById(long idCourse) {
        if(courseRepo.existsCourseById(idCourse)) {
            courseRepo.removeCourseById(idCourse);
            return "Course Removed Successfully";
        }
        else {
            return "Course not found!";
        }
    }
}
