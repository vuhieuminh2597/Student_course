package com.hieupc.student_management.repository;

import com.hieupc.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT S FROM Student S" +
            " WHERE S.isDelete = FALSE " +
            "ORDER BY S.id ASC")
    List<Student> findAllStudent();

    @Query("SELECT S FROM Student S " +
            "WHERE  S.id = :id AND S.isDelete = FALSE ")
    Optional<Student> findById(@Param("id") Integer id);

    @Query("SELECT S FROM Student S " +
            "WHERE S.name = :name")
    Optional<Student> findByName(@Param(("name")) String name);

    @Modifying
    @Query("UPDATE Student S " +
            "SET S.isDelete = TRUE " +
            "WHERE S.id = :id")
    void deleteById(@Param("id") Integer id);

    @Query("SELECT S.id FROM Student S ORDER BY S.id DESC LIMIT 1")
    Integer getLargestId ();
}
