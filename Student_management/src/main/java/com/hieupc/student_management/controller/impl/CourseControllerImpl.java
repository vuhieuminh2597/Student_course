package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/Course")
public class CourseControllerImpl implements BaseController<Course,Integer> {
    private CourseService courseService;

    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<Course> get() {
        return null;
    }

    @Override
    public ResponseEntity<Course> getByIdController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Course> postController(Course newObject) {
        return null;
    }

    @Override
    public ResponseEntity<Course> putController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Course> pathController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Course> deleteController(Integer integer) {
        return null;
    }
}
