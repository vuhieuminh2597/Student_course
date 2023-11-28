package com.hieupc.student_management.service;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.model.StudentDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseService {
    List<Course> findAllCourse();
    Optional<CourseDTO> findByIdService(Long id);
    List<StudentDTO> updateAllStudentInCourse(Optional<Course> Course);
}
