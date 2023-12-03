package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.Exception.ResourceNotFoundException;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.mapper.CourseMapper;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.repository.CourseRepository;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAllCourse();
}

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Course was not found with given id: " + id));
        return courseMapper.mapToCourseDTO(course);
    }

    @Override
    public CourseDTO creatCourse(CourseDTO newCourse) {
        Course courseMap = courseMapper.mapToCourseEntity(newCourse);
        courseMap.setId(courseRepository.getLargestId() + 1);
        Course courseSave = courseRepository.save(courseMap);
        return courseMapper.mapToCourseDTO(courseSave);
    }

    @Override
    public CourseDTO updateCourse(Integer integer, CourseDTO student) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {
        return false;
    }
}
