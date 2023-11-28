package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.repository.StudentRepository;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
