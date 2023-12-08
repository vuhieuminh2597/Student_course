package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.model.ReponseObject;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")//Spring security
@RequestMapping(path = "api/v1/Course")
public class CourseControllerImpl implements BaseController<CourseDTO, Course, Integer> {
    private CourseService courseService;

    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Course>> getAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CourseDTO> getByIdController(@PathVariable("id") Integer id) {
        CourseDTO courseDTO = (CourseDTO) courseService.findById(id);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @PostMapping("/insert")
    @Override
    public ResponseEntity<CourseDTO> postController(@RequestBody CourseDTO newObject) {
        CourseDTO courseDTO = (CourseDTO) courseService.creatCourse(newObject);
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    @Override
    public ResponseEntity<CourseDTO> putController(@PathVariable("id") Integer id, @RequestBody CourseDTO update) {
        CourseDTO courseDTO = (CourseDTO) courseService.updateCourse(id, update);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<ReponseObject> deleteController(@PathVariable("id") Integer id) {
        boolean value = courseService.deleteById(id);
        if (value) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject("OK", "Delete course Successfully!")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Failed", "Course was not found with given id: " + id)
            );
        }
    }

    @PatchMapping("/patch/{id}")
    @Override
    public ResponseEntity<CourseDTO> patchController(@PathVariable("id") Integer id,@RequestBody CourseDTO newObject) {
        CourseDTO courseDTO = (CourseDTO) courseService.patchCourse(id,newObject);
        return new ResponseEntity<>(courseDTO,HttpStatus.OK);
    }
}
