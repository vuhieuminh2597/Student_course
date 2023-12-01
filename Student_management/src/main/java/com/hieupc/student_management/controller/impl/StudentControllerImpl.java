package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.BaseController;
import com.hieupc.student_management.entity.Student;
import com.hieupc.student_management.model.StudentDTO;
import com.hieupc.student_management.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Student")
public class StudentControllerImpl implements BaseController<StudentDTO, Student, Integer> {
    private BaseService studentService;

    @Autowired
    public StudentControllerImpl(BaseService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<StudentDTO>> getAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<StudentDTO> getByIdController(@PathVariable("id") Integer id) {
        StudentDTO studentDTO = (StudentDTO) studentService.findById(id);
        return new  ResponseEntity<>(studentDTO,HttpStatus.OK);
    }
    @PostMapping("/insert")
    @Override
    public ResponseEntity<StudentDTO> postController(Student newObject) {
        return null;
    }


    @Override
    public ResponseEntity<StudentDTO> putController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<StudentDTO> pathController(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<StudentDTO> deleteController(Integer integer) {
        return null;
    }


}
