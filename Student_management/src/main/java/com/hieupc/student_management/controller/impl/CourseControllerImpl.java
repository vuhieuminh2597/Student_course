package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Course")
public class CourseControllerImpl implements BaseController<CourseDTO, Course, Integer> {
    private BaseService courseService;

    @Autowired
    public CourseControllerImpl(BaseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> getByIdController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> postController(CourseDTO newObject) {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> putController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> pathController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<CourseDTO> deleteController(Integer integer) {
        return null;
    }
}
