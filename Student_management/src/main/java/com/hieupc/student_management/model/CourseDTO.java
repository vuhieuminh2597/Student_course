package com.hieupc.student_management.model;

import com.hieupc.student_management.entity.Student;

import java.util.List;

public class CourseDTO {
    private Long id;
    private String name;

    private List<StudentDTO> studentList;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, List<StudentDTO> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", studentList=" + studentList.toString() +
                '}';
    }
}
