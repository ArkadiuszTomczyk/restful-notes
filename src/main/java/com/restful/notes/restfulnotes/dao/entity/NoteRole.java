package com.restful.notes.restfulnotes.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class NoteRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ROLE_ID_SEQ")
    @SequenceGenerator(name = "NOTE_ROLE_ID_SEQ", sequenceName = "NOTE_ROLE_ID_SEQ")

    private Long id;
    private String name;

}
