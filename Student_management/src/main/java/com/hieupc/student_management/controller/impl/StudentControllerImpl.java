package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Student")
public class StudentControllerImpl implements BaseController<Student, Integer> {
    private StudentService studentService;

    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public ResponseEntity<Student> get() {
        return null;
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Student> getByIdController(@PathVariable("id") Integer id) {
        return ResponseEntity.of(studentService.findById(id));
    }

    @Override
    public ResponseEntity<Student> postController(@RequestBody Student newObject) {
        return null;
    }

    @Override
    public ResponseEntity<Student> putController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Student> pathController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Student> deleteController(Integer integer) {
        return null;
    }


}
