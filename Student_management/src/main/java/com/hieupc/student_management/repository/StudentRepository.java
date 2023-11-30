package com.hieupc.student_management.repository;

import com.hieupc.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT S FROM Student S WHERE S.isDelete = FALSE ")
    List<Student> findAllStudent();
    @Query("SELECT S FROM Student S WHERE  S.id = :id AND S.isDelete = FALSE ")
    Optional<Student> findById(@Param("id") Integer id);
}
