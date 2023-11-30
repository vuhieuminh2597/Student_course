package com.hieupc.student_management;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.service.impl.CourseServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(StudentManagementApplication.class, args);
    }

}
