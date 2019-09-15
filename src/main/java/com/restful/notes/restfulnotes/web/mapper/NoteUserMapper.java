package com.restful.notes.restfulnotes.web.mapper;

import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NoteUserMapper {

    public static NoteUserModel fromUserEntity(NoteUser noteUser) {
        NoteUserModel noteUserModel = new NoteUserModel();
        BeanUtils.copyProperties(noteUserModel, noteUser);
        return noteUserModel;
    }

    public static NoteUser fromModel(NoteUserModel noteUserModel) {
        NoteUser noteUser = new NoteUser();
        noteUser.setId(noteUserModel.getId());
        noteUser.setUsername(noteUserModel.getUsername());
        noteUser.setPassword(noteUserModel.getPassword());
        return noteUser;
    }
//    before changes
//    public static NoteUser fromModel(NoteUserModel noteUserModel) {
//        NoteUser noteUser = new NoteUser();
//        BeanUtils.copyProperties(noteUserModel, noteUser);
//        return noteUser;
//    }

}
