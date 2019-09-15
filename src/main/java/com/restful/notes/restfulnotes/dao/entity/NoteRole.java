package com.restful.notes.restfulnotes.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class NoteRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ROLE_ID_SEQ")
    @SequenceGenerator(name = "NOTE_ROLE_ID_SEQ", sequenceName = "NOTE_ROLE_ID_SEQ")
    private Long id;

    @Column(name = "NOTE_USERS_NAME")
    private String name;

    @OneToMany(mappedBy = "note_role", cascade = CascadeType.ALL)
    private Set<NoteUser> noteUsers= new HashSet<>();

}
