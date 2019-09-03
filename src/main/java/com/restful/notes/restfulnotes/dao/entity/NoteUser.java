package com.restful.notes.restfulnotes.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NOTE_USERS")
public class NoteUser {

//    Long id;
//    id++;
//    id- pobierz aktualną wartość
//    id - zwiększ wartość
//    id - przypisz wartość
//    AtomicLong aId;
//    aId.getAndIncrement()
//    pozbawione wad poprzedników jednak też ma wady
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_USERS_ID_SEQ")
@SequenceGenerator(name = "NOTE_USERS_ID_SEQ", sequenceName = "NOTE_USERS_ID_SEQ")
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
