package com.hieupc.student_management.mapper;

import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.StudentDTO;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {

    public Student mapToEntity(StudentDTO object) {
        Student student = new Student();
//        student.setId(object.getId());
        student.setName(object.getName());
        student.setBirthDay(object.getBirthDay());
        student.setEmail(object.getEmail());
        student.setAddress(object.getAddress());
        student.setPhoneNumber(object.getPhoneNumber());
        return student;
    }


    public StudentDTO mapToModelDTO(Student object) {
        return new StudentDTO(object.getId(),object.getName()
                , object.getBirthDay(), object.getEmail()
                , object.getAddress(), object.getPhoneNumber());
    }
}
