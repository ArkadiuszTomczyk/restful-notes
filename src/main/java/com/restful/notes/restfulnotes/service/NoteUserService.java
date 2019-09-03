package com.restful.notes.restfulnotes.service;

import com.restful.notes.restfulnotes.dao.NoteUserRepository;
import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import com.restful.notes.restfulnotes.web.mapper.NoteUserMapper;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteUserService {
    @Autowired
   private NoteUserRepository noteUserRepository;


    public void save(NoteUserModel noteUserModel){
        final NoteUser noteUser = NoteUserMapper.fromModel(noteUserModel);
        noteUserRepository.save(noteUser);
    }

}
