package com.hieupc.student_management.service;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.StudentDTO;

import java.util.List;

public interface StudentService<T,V,ID> {

    List<V> findAll();
    T findById(ID id);

    T creatStudent(T newStudent);

    T updateStudent(ID id, T student);
    boolean deleteById (ID id);
    Course register(ID idStudent, ID idCourse);

    T patchStudent(ID id, T studentDTO);
}
