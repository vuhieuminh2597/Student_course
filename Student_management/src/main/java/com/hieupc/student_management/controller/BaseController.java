package com.hieupc.student_management.controller;

import com.hieupc.student_management.model.ReponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BaseController<T, V, ID> {//T = Type,V = Value,ID = number Object (Integer,Long,Double...)

    ResponseEntity<List<V>> getAll();

    ResponseEntity<T> getByIdController(ID id);

    ResponseEntity<T> postController(T newObject);

    ResponseEntity<T> putController(ID id, T update);

    ResponseEntity<ReponseObject> deleteController(ID id);

    ResponseEntity<T> patchController (ID id,T newObject);
}
