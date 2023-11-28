package com.hieupc.student_management.controller;

import com.hieupc.student_management.entity.Student;

import java.util.List;

public interface StudentController {

    List<Student> findAllStudent();
}
