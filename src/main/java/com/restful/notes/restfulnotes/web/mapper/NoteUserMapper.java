package com.restful.notes.restfulnotes.web.mapper;

import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NoteUserMapper {
    public static NoteUser fromModel(NoteUserModel noteUserModel) {
        NoteUser noteUser = new NoteUser();
        BeanUtils.copyProperties(noteUserModel, noteUser);
        return noteUser;
    }



}
