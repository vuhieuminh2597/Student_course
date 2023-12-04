package com.hieupc.student_management.model;


import com.hieupc.student_management.entity.Course;

import java.util.List;
import java.util.Set;

public class StudentDTO {
    private Integer id;
    private String name;
    private String birthDay;
    private String email;
    private String address;
    private String phoneNumber;
//    private Set<Course> courseDTOList;

    public StudentDTO() {
    }

    public StudentDTO(String name, String birthDay, String email, String address, String phoneNumber) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StudentDTO(Integer id, String name, String birthDay, String email, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    @Override
//    public String toString() {
//        return "studentDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", birthDay='" + birthDay + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", courseDTOList=" + courseDTOList.toString() +
//                '}';
//    }


    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
