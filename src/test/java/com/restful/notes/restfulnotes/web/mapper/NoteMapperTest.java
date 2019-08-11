package com.restful.notes.restfulnotes.web.mapper;

import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import com.restful.notes.restfulnotes.web.model.NoteModel;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteMapperTest {

    private static final String NOTE_TITLE = "title";
    private static final String NOTE_CONTENT = "content";
    private static final String MODEL_TITLE = "Model title";
    private static final String MODEL_CONTENT = "should be something";
    private static final Long MODEL_ID = 12L;

    @Test
    public void givenNoteEntity_WhenNoteMapperFromEntity_ThenTitleEquals() {
        //given
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        //when
        final NoteModel noteModel = NoteMapper.fromEntity(noteEntity);
        //then
        final String title = noteModel.getTitle();
        Assert.assertEquals("titles aren't equal", NOTE_TITLE, title);
    }

    @Test
    public void givenNoteEntity_WhenNoteMapperFromEntity_ThenContentEquals() {
        //given
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        //when
        final NoteModel noteModel = NoteMapper.fromEntity(noteEntity);
        //then
        final String content = noteModel.getContent();
        Assert.assertEquals("titles aren't equal", NOTE_CONTENT, content);
    }

    @Test
    public void givenNoteEntity_WhenNoteMapperFromEntity_ThenTheObjectsAreEquals() {
        //given
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        //when
        final NoteModel noteModel = NoteMapper.fromEntity(noteEntity);
        //then
    //porównanie pole po polu
        assertThat(noteEntity)
                .isEqualToComparingFieldByFieldRecursively(noteModel);
    }

    @Test
    public void givenNotModel_WhenNoteMapperFromModel_ThenContentEquals() {
        //given
        NoteModel noteModel = new NoteModel(MODEL_TITLE, MODEL_CONTENT);
        //when
        final NoteEntity noteEntity = NoteMapper.fromModel(noteModel);

        //then
        final String content = noteEntity.getContent();
        Assert.assertEquals("not equal", MODEL_CONTENT, content);
    }

    @Test
    public void givenNoteModel_WhenNoteMapperFromModel_ThenTheObjectsAreEquals() {
        //given
        NoteModel noteModel = new NoteModel(MODEL_ID ,MODEL_TITLE, MODEL_CONTENT  );
        //when
        final NoteEntity noteEntity = NoteMapper.fromModel(noteModel);
        //then
        assertThat(noteModel)
                .isEqualToComparingFieldByFieldRecursively(noteEntity);
    }

    //todo dodać testy jednostkowe dla NoteEntity oraz NoteModel
}