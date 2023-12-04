package com.hieupc.student_management.mapper;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course mapToCourseEntity(CourseDTO object) {
        Course course = new Course();
        course.setId(object.getId());
        course.setName(object.getName());
        course.setStudentList(object.getStudentList());
        return course;
    }


    public CourseDTO mapToCourseDTO(Course object) {
        return new CourseDTO(object.getId(), object.getName(),object.getStudentList());
    }
}
