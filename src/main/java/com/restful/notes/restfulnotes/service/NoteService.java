package com.restful.notes.restfulnotes.service;

import com.restful.notes.restfulnotes.dao.NoteRepository;
import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import com.restful.notes.restfulnotes.web.mapper.NoteMapper;
import com.restful.notes.restfulnotes.web.model.NoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    public List<NoteModel> notes() {
        List<NoteModel> noteModelList = new ArrayList<>();
        //Delegate design pattern here
        final List<NoteEntity> noteEntityList = noteRepository.findAll();
        for (NoteEntity noteEntity : noteEntityList) {
            NoteModel noteModel = NoteMapper.fromEntity(noteEntity);
            noteModelList.add(noteModel);
        }
//        return noteEntityList;
        return noteModelList;
    }

    public NoteModel note(Long id) {
        final Optional<NoteEntity> noteEntityOptional = noteRepository.findById(id);
        if (noteEntityOptional.isPresent()) {
            final NoteEntity noteEntity = noteEntityOptional.get();
            final NoteModel noteModel = NoteMapper.fromEntity(noteEntity);
            return noteModel;
        }
        return null;
    }


    public NoteModel save(NoteModel noteModel) {
        NoteEntity noteEntity = NoteMapper.fromModel(noteModel);
        noteRepository.save(noteEntity);
        return noteModel;
    }

    public NoteModel update(NoteModel noteModel) {
        NoteEntity noteEntity = NoteMapper.fromModel(noteModel);
        noteRepository.save(noteEntity);
        return noteModel;
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
// dto == model zgodnie z mvc
// VO (value object) == entity zgodnie z Hibernate'm