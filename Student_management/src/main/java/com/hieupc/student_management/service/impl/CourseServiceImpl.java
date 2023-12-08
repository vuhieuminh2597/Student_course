package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.exception.ResourceNotFoundException;
import com.hieupc.student_management.mapper.CourseMapper;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.repository.CourseRepository;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService<CourseDTO,Course,Integer> {
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
                new ResourceNotFoundException("Course was not found with given id: " + id));
        courseEntity.setName(course.getName());
        Course courseSave = courseRepository.save(courseEntity);
        return courseMapper.mapToCourseDTO(courseSave);
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            for (Iterator<Student> it = course.get().getStudentList().iterator();
                 it.hasNext(); ) {
                Student c = it.next();
                c.getCourseList().remove(course);
            }
            courseRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public CourseDTO patchCourse(Integer id, CourseDTO course) {
        Course courseEntity = courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Course was not found with given id: " + id));
        Course courseSave = courseRepository.save(updateCourseByPatch(courseEntity,course));
        return courseMapper.mapToCourseDTO(courseSave);
    }

    private Course updateCourseByPatch(Course course, CourseDTO courseDTO) {
        Course courseSave = course;
        if(courseDTO.getName() != null){
            courseSave.setName(courseDTO.getName());
        }
        return courseSave;
    }
}
