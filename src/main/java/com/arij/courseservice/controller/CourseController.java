package com.arij.courseservice.controller;


import com.arij.courseservice.entities.Course;
import com.arij.courseservice.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/course-controller")
@AllArgsConstructor
@RestController
public class CourseController {
    CourseService courseService;
    @GetMapping(path = "/getAllCourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @DeleteMapping("/deleteCourse/{idCourse}")
    public String deleteCourseById(@PathVariable("idCourse") long idCourse){
        return courseService.deleteCourseById(idCourse);
    }
    @GetMapping("/getCoursesByName/{courseName}")
    public List<Course> getCoursesByName(@PathVariable("courseName") String courseName){
        return courseService.getCoursesByName(courseName);
    }

    @GetMapping("/getCourseDetails/{idCourse}")
    public Course getCourseById(@PathVariable("idCourse") long idCourse){
        return  courseService.getCourseById(idCourse);
    }

    @GetMapping("/getAllCoursesByUserId/{idTeacher}")
    public List<Course> getAllCoursesByUserId(@PathVariable("idTeacher") long idTeacher){
        return courseService.getAllCoursesByUserId(idTeacher);
    }



}
