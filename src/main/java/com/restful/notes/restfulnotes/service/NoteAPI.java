package com.restful.notes.restfulnotes.service;

import com.restful.notes.restfulnotes.web.controller.TaskNotFoundException;

import java.util.List;

public interface NoteAPI<T> {
    List<T> findAll();
    T findById(Long id) throws TaskNotFoundException;
    T save(T t);
    T update(T t);
    T delete(T t);
}
