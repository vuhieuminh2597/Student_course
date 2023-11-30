package com.hieupc.student_management.service;

import com.hieupc.student_management.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudent();
    Optional<Student> findById(Integer id);
}
