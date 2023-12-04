package com.hieupc.student_management.controller;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface RegisterCourseController {
    ResponseEntity<Course> registerCourse(Integer idStudent, Integer idCourse);
}
