package com.hieupc.student_management.model;

import com.hieupc.student_management.entity.Student;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CourseDTO {
    private Integer id;
    private String name;
    private Set<Student> studentList;

    public CourseDTO() {
    }

    public CourseDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseDTO(Integer id, String name, Set<Student> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDTO courseDTO = (CourseDTO) o;
        return Objects.equals(id, courseDTO.id) && Objects.equals(name, courseDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList.toString() +
                '}';
    }
}
