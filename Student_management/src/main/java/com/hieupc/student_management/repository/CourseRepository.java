package com.hieupc.student_management.repository;

import com.hieupc.student_management.entity.Course;
import com.hieupc.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT C FROM Course C ORDER BY C.id ASC")
    List<Course> findAllCourse();

    @Query("SELECT C FROM Course C " +
            "WHERE C.name = :name")
    Optional<Course> findByName(@Param(("name")) String name);

    @Query("SELECT C.id FROM Course C ORDER BY C.id DESC LIMIT 1")
    Integer getLargestId ();
}
