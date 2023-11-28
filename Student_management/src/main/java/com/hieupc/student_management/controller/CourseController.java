package com.hieupc.student_management.controller;

import com.hieupc.student_management.entity.Course;

import java.util.List;

public interface CourseController {
    List<Course> findAllCourse();
}
