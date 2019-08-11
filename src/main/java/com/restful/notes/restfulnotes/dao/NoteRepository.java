package com.restful.notes.restfulnotes.dao;

import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
