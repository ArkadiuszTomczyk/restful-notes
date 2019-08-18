package com.restful.notes.restfulnotes.dao;

import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteUserRepository extends JpaRepository <NoteUser, Long>{
    NoteUser findByUsername(String username);
}
