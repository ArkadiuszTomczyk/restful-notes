package com.restful.notes.restfulnotes.service;

import com.restful.notes.restfulnotes.dao.NoteUserRepository;
import com.restful.notes.restfulnotes.dao.entity.NoteUser;
import com.restful.notes.restfulnotes.web.mapper.NoteUserMapper;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteUserService {
    @Autowired
   private NoteUserRepository noteUserRepository;

    public void save(NoteUserModel noteUserModel){
        final NoteUser noteUser = NoteUserMapper.fromModel(noteUserModel);
        noteUserRepository.save(noteUser);
    }

//    todo moje

    @Autowired
    NoteUserMapper noteUserMapper;

//    todo zrobić na wzór NoteService
// powinniśmy zrobić UserMapper?
//     no ja zrobiłem
    public List<NoteUserModel> userModels() {
        List<NoteUserModel> noteUserModelList = new ArrayList<>();
        final List<NoteUser> noteUsersList = noteUserRepository.findAll();
        for (NoteUser  noteUser : noteUsersList ) {
             NoteUserModel noteUserModel = NoteUserMapper.fromUserEntity(noteUser);
             noteUserModelList.add(noteUserModel);
         }
        return noteUserModelList;
    }

    public NoteUserModel find(NoteUserModel noteUserModel) {
        final NoteUser noteUser = NoteUserMapper.fromModel(noteUserModel);
        noteUserRepository.findByUsername(noteUser.getUsername());
        return noteUserModel;
    }

    public NoteUserModel update(NoteUserModel noteUserModel){
        final NoteUser noteUser = NoteUserMapper.fromModel(noteUserModel);
        noteUserRepository.save(noteUser);
        return noteUserModel;
    }



}
