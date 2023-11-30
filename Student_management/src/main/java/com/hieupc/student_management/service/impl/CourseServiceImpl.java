package com.hieupc.student_management.service.impl;

import com.hieupc.student_management.repository.CourseRepository;
import com.hieupc.student_management.repository.StudentRepository;
import com.hieupc.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

//    @Override
//    public List<Course> findAllCourse() {
//        return courseRepository.findAll();
//    }
//
//    @Override
//    public Optional<CourseDTO> findByIdService(Long id) {
//        Optional<Course> course = courseRepository.findById(id);
//        if (course.isPresent()) {
//            Optional<CourseDTO> courseDTO = Optional.of(new CourseDTO(
//                    course.get().getId(),
//                    course.get().getName(),
//                    updateAllStudentInCourse(course)
//            ));
//            return courseDTO;
//        }
//        return null;
//    }
////
//    @Override
//    public List<StudentDTO> updateAllStudentInCourse(Optional<Course> course) {
//        List<StudentDTO> studentInCourse = new ArrayList<>();
//        List<Student> studentList = studentRepository.findAll();//lấy danh sách tất cả sinh viên
//
//        if (!studentList.isEmpty()) {//Nếu không rỗng
//            for (Student student :
//                    studentList) {//Travel qua danh sách các học sinh
//
//                if (!student.getCourseList().isEmpty()) {//nếu có tham gia lớp học nào đó
//                    if (checkIdCourse(student, course.get().getId())) {//Check id khóa học mà học sinh tham gia
//                        studentInCourse.add(new StudentDTO(student.getName(),
//                                student.getBirthDay()
//                                , student.getAddress()));//Add student transfer  qua StudentDTO
//                    }
//
//                }
//            }
//        }
//        return studentInCourse;
//    }
//
//    public Course queryByNameCourse(String name) {
//        Course course = courseRepository.queryByName(name);
//        return course;
//    }
//
//    private boolean checkIdCourse(Student student, Long id) {
//        for (Course course :
//                student.getCourseList()) {
//            if (course.getId() == id) {
//                return true;
//            }
//        }
//        return false;
//    }
}
