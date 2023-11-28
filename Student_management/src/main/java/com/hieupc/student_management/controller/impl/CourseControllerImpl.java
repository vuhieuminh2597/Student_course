package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.CourseController;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Course")
public class CourseControllerImpl implements CourseController {
    private CourseService courseService;

    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    @Override
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    @GetMapping("/{id}")
    @Override
    public Optional<CourseDTO> findByIdController(@PathVariable Long id) {
        return courseService.findByIdService(id);
    }
}
