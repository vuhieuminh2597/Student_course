package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.Exception.ResourceNotFoundException;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.mapper.StudentMapper;
import com.hieupc.student_management.model.StudentDTO;
import com.hieupc.student_management.repository.StudentRepository;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService<StudentDTO, Student, Integer> {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllStudent();
    }

    @Override
    public StudentDTO findById(Integer id) {
        Student student1 = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student was not found with given id: " + id));
        return studentMapper.mapToModelDTO(student1);
    }

    @Override
    public StudentDTO creatStudent(StudentDTO newStudent) {
        Student studentMap = studentMapper.mapToEntity(newStudent);
        studentMap.setId(studentRepository.getLargestId() + 1);
        Student student = studentRepository.save(studentMap);
        return studentMapper.mapToModelDTO(student);
    }

    @Override
    public StudentDTO updateStudent(Integer id, StudentDTO student) {
        Student studentEntity = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student was not found with given id: " + id));
        studentEntity.setName(student.getName());
        studentEntity.setBirthDay(student.getBirthDay());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setPhoneNumber(student.getPhoneNumber());
        Student studentSave = studentRepository.save(studentEntity);
        return studentMapper.mapToModelDTO(studentSave);
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if (student1.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
