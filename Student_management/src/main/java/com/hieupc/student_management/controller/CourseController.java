package com.hieupc.student_management.controller;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseController {
    List<Course> findAllCourse();
    Optional<CourseDTO> findByIdController(Long id);
}
