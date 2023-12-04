package com.hieupc.student_management.service;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;

import java.util.List;

public interface CourseService<T,V,ID> {

    List<V> findAll();
    T findById(ID id);

    T creatCourse(T newCourse);

    T updateCourse(ID id, T course);
    boolean deleteById (Integer id);

    T patchCourse (ID id ,T course);
}
