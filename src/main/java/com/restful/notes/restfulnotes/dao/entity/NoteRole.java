package com.restful.notes.restfulnotes.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NoteRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
