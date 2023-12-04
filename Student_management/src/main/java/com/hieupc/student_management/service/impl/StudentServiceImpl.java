package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.exception.ResourceNotFoundException;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.mapper.CourseMapper;
import com.hieupc.student_management.mapper.StudentMapper;
import com.hieupc.student_management.model.StudentDTO;
import com.hieupc.student_management.repository.CourseRepository;
import com.hieupc.student_management.repository.StudentRepository;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService<StudentDTO, Student, Integer> {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentMapper studentMapper;
    private CourseMapper courseMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper,
                              CourseRepository courseRepository, CourseMapper courseMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
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
            student1.get().getCourseList().clear();
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Course register(Integer idStudent, Integer idCourse) {
        Student studentEntity = studentRepository.findById(idStudent).orElseThrow(() ->
                new ResourceNotFoundException("Student was not found with given id: " + idStudent));

        Course courseEntity = courseRepository.findById(idCourse).orElseThrow(() ->
                new ResourceNotFoundException("Course was not found with given id: " + idCourse));
        studentEntity.setCourseList(courseEntity);
        courseEntity.setStudentList(studentEntity);
        studentRepository.save(studentEntity);
        Course courseSave = courseRepository.save(courseEntity);
        return courseSave;
    }

    @Override
    public StudentDTO patchStudent(Integer id, StudentDTO studentDTO) {
        Student studentEntity = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student was not found with given id: " + id));
        Student studentSave = studentRepository.save(updateStudentByPatch(studentEntity,studentDTO));
        return studentMapper.mapToModelDTO(studentSave);
    }

    public Student updateStudentByPatch(Student student, StudentDTO studentDTO) {
        Student studentSave = student;
        if (studentDTO.getName() != null) {
            studentSave.setName(studentDTO.getName());
        }
        if (studentDTO.getAddress() != null) {
            studentSave.setAddress(studentDTO.getAddress());
        }
        if (studentDTO.getBirthDay() != null) {
            studentSave.setBirthDay(studentDTO.getBirthDay());
        }
        if (studentDTO.getEmail() != null) {
            studentSave.setEmail(studentDTO.getEmail());
        }
        if (studentDTO.getPhoneNumber() != null) {
            studentSave.setPhoneNumber(studentDTO.getPhoneNumber());
        }
        return studentSave;
    }
}
