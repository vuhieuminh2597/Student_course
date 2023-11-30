package com.hieupc.student_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BaseController<T, V, ID> {//T = Type,ID = number Object (Integer,Long,Double...)

    List<V> getAll();

    ResponseEntity<T> getByIdController(ID id);

    ResponseEntity<T> postController(T newObject);

    ResponseEntity<T> putController(ID id);

    ResponseEntity<T> pathController(ID id);

    ResponseEntity<T> deleteController(ID id);
}
