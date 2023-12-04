package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.exception.ResourceNotFoundException;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.mapper.CourseMapper;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.repository.CourseRepository;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Course courseSave = courseRepository.save(courseMap);
        return courseMapper.mapToCourseDTO(courseSave);
    }

    @Override
    public CourseDTO updateCourse(Integer id ,CourseDTO course) {
        Course courseEntity = courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student was not found with given id: " + id));
        courseEntity.setName(course.getName());
        Course courseSave = courseRepository.save(courseEntity);
        return courseMapper.mapToCourseDTO(courseSave);
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            courseRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
