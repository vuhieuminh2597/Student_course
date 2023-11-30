package com.hieupc.student_management.service;

import com.hieupc.student_management.model.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T,V,ID> {

    List<V> findAll();
    Optional<T> findById(ID id);
}
