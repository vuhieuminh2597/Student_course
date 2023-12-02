package com.hieupc.student_management.model;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentDTO {
    private Integer id;
    private String name;
    private String birthDay;
    private String email;
    private String address;
    private String phoneNumber;
    private List<CourseDTO> courseDTOList;

    public StudentDTO() {
    }

    public StudentDTO(String name, String birthDay, String email, String address, String phoneNumber) {
        this.setId(null);
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StudentDTO(Integer id, String name, String birthDay, String email, String address, String phoneNumber) {
        this.setId(id);
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public StudentDTO(Integer id, String name, String birthDay, String email, String address, String phoneNumber,
                      List<CourseDTO> courseDTOList) {
        this.setId(id);
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.courseDTOList = courseDTOList;
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

    public List<CourseDTO> getCourseDTOList() {
        return courseDTOList;
    }

    public void setCourseDTOList(List<CourseDTO> courseDTOList) {
        this.courseDTOList = courseDTOList;
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
