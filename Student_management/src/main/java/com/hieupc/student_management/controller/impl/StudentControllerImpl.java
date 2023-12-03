package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.ReponseObject;
import com.hieupc.student_management.model.StudentDTO;
import com.hieupc.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Student")
public class StudentControllerImpl implements BaseController<StudentDTO, Student, Integer> {
    private StudentService studentService;

    @Autowired
    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<StudentDTO> getByIdController(@PathVariable("id") Integer id) {
        StudentDTO studentDTO = (StudentDTO) studentService.findById(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/insert")
    @Override
    public ResponseEntity<StudentDTO> postController(@RequestBody StudentDTO newStudent) {
        StudentDTO studentDTO = (StudentDTO) studentService.creatStudent(newStudent);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    @Override
    public ResponseEntity<StudentDTO> putController(@PathVariable("id") Integer id, @RequestBody StudentDTO student) {
        StudentDTO studentDTO = (StudentDTO) studentService.updateStudent(id, student);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<ReponseObject> deleteController(@PathVariable("id") Integer id) {
        boolean value = studentService.deleteById(id);
        if (value) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ReponseObject("OK", "Delete student Successfully!")
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ReponseObject("Failed", "Student was not found with given id: " + id)
            );
        }
    }


}
