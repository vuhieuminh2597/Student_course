package com.hieupc.student_management.controller;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseController {
    List<Course> findAllCourse();
    ResponseEntity<ResponseObject> findByIdController(Long id);
//    ResponseEntity<ResponseObject> insertNewCourse(Course newCourse);
}
