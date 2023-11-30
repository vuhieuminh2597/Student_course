package com.hieupc.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(StudentManagementApplication.class, args);
    }

}
