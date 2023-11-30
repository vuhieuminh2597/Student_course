package com.hieupc.student_management.controller;

import org.springframework.http.ResponseEntity;

public interface BaseController<T, ID> {//T = Type,ID = number Object (Integer,Long,Double...)
    ResponseEntity<T> get();

    ResponseEntity<T> getByIdController(ID id);

    ResponseEntity<T> postController(T newObject);

    ResponseEntity<T> putController(ID id);

    ResponseEntity<T> pathController(ID id);

    ResponseEntity<T> deleteController(ID id);
}
