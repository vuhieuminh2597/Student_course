package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.StudentController;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Student")
public class StudentControllerImpl implements StudentController {
    private StudentService studentService;

    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Phương thức trả ra Rest API chứa list students
     * @return List students
     */
    @GetMapping("")
    @Override
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

}
