package com.restful.notes.restfulnotes.web.mapper;

import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import com.restful.notes.restfulnotes.web.model.NoteModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public static NoteModel fromEntity(NoteEntity noteEntity){
        NoteModel noteModel = new NoteModel();
        BeanUtils.copyProperties(noteEntity, noteModel);
        return noteModel;
    }
    public static NoteEntity fromModel(NoteModel noteModel) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(noteModel.getId());
        noteEntity.setTitle(noteModel.getTitle());
        noteEntity.setContent(noteModel.getContent());
        return noteEntity;
    }

}
