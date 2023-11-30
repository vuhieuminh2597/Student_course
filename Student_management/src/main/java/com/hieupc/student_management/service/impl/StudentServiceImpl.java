package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.StudentDTO;
import com.hieupc.student_management.repository.StudentRepository;
import com.hieupc.student_management.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements BaseService<StudentDTO,Student,Integer> {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllStudent();
    }

    @Override
    public Optional<StudentDTO> findById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return Optional.of(new StudentDTO(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getBirthDay(),
                    student.get().getEmail(),
                    student.get().getAddress(),
                    student.get().getPhoneNumber()
            ));

        }
        return Optional.empty();
    }
}
