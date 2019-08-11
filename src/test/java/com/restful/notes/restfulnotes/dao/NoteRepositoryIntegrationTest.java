package com.restful.notes.restfulnotes.dao;

import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestNoteRepositoryContextConfiguration.class)
@TestPropertySource(locations = "classpath:test-application.properties")
@Transactional
public class NoteRepositoryIntegrationTest {

    public static final String NOTE_TITLE = "new beatles";
    public static final String NOTE_CONTENT = "not exist";
    private static final Long NOTE_ID = 1L;
    //    ctrl+alt+c = tworzenie stalych ze zmiennej
    @Autowired
    private NoteRepository noteRepository;


    //    @Commit
//    tak nie robic - sluzy do prezentacji czy zapis dziala
    @Test
    public void save() {
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        final NoteEntity savedNote = noteRepository.save(noteEntity);
        final NoteEntity noteFromDb = noteRepository.findById(savedNote.getId()).get();
        Assert.assertEquals("", NOTE_TITLE, noteFromDb.getTitle());

    }

    @Test
    public void notes() {
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        noteRepository.save(noteEntity);
        noteRepository.save(new NoteEntity("asd", "kjhg"));

        final List<NoteEntity> notes = noteRepository.findAll();
        Assert.assertEquals("", 2, notes.size());

    }

    @Test
    public void read() {

    }

    @Test
    public void update() {
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        final NoteEntity savedNote = noteRepository.save(noteEntity);
        final NoteEntity noteFromDb = noteRepository.findById(savedNote.getId()).get();
        Assert.assertEquals("", NOTE_TITLE, noteFromDb.getTitle());
    }

    @Test
    public void delete() {
//        given
//        noteRepository.deleteAll();
        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        final NoteEntity savedNote = noteRepository.save(noteEntity);
        final NoteEntity noteFromDb = noteRepository.findById(savedNote.getId()).get();
//        when
        noteRepository.delete(savedNote);
//        then
        final int size = noteRepository
                .findAll()
                .size();
        Assert.assertEquals(size, 0);

    }

    @Test
    public void delete2() {
        NoteRepository noteRepo = Mockito.mock(NoteRepository.class);
//        given
        List<NoteEntity> notes = new ArrayList<>();

        NoteEntity noteEntity = new NoteEntity(NOTE_TITLE, NOTE_CONTENT);
        noteEntity.setId(NOTE_ID);
        notes.add(noteEntity);

        Mockito.when(noteRepo.findById(NOTE_ID)).thenReturn(Optional.of(noteEntity));
        Mockito.when(noteRepo.findAll()).thenReturn(notes);
//        when
        final NoteEntity noteFromDb = noteRepo.findById(noteEntity.getId()).get();
        noteRepo.delete(noteFromDb);
        notes.remove(noteEntity);
//        then
        final int size = noteRepo
                .findAll()
                .size();
        Assert.assertEquals(size, 0);
    }

//    todo zrobic testy integracyjne dla metod read(), update(), delete()

}

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestNoteRepositoryContextConfiguration.class)

//    @Autowired
//    private NoteRepository noteRepository;

//Mockito.when(noteRepository.findById(NOTE_ID)).thenReturn(Optional.of(noteEntity));
// powyższe nie zadziała ze względu na brak Mock'ów na noteRepository
// noteRepository jest wstrzyknięte i zarządzane przez Spring'a



//NoteRepository noteRepo = Mockito.mock(NoteRepository.class);
//Mockito.when(noteRepo.findById(NOTE_ID)).thenReturn(Optional.of(noteEntity));
// powyższe zadziała, bo noteRepo jest Mock'iem