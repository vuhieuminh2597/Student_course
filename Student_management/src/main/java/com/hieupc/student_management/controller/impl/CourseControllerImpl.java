package com.hieupc.student_management.controller.impl;

import com.hieupc.student_management.controller.CourseController;
import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.model.CourseDTO;
import com.hieupc.student_management.model.ResponseObject;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Course")
public class CourseControllerImpl implements CourseController {
    private CourseService courseService;

    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Phương thức trả ra Rest API list courses
     *
     * @return list courses
     */
    @GetMapping("")
    @Override
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    /**
     * Phương thức nhận vào mã id trả ra Rest API an courseDTO
     * Phương thức đã được xử lý trước khi gửi dữ liệu đến client
     * -status : trạng thái đã tìm thấy data  OK or Failed
     * -message :Nội dung
     * -data : Object
     *
     * @param id course id
     * @return ResponseEntity<ResponseObject>
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ResponseObject> findByIdController(@PathVariable Long id) {
        Optional<CourseDTO> data = courseService.findByIdService(id);

        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Find by id successfully!", data)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Not found course with id:'" + id + "'", "{}")
            );
        }
    }

//    @PostMapping("/insert")
//    @Override
//    public ResponseEntity<ResponseObject> insertNewCourse(@RequestBody Course newCourse) {
//        Optional<Course> course = courseService.queryByNameCourse(newCourse);
//        if (course.isPresent()) {
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("OK", "Insert course successfully!", course)
//            );
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    new ResponseObject("Failed", "Course already exist", "")
//            );
//        }
//    }

}
