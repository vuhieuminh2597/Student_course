package com.hieupc.student_management.service;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    CourseDTO findById(Integer id);

    CourseDTO creatCourse(CourseDTO newCourse);

    CourseDTO updateCourse(Integer id, CourseDTO course);
    boolean deleteById (Integer id);
}
