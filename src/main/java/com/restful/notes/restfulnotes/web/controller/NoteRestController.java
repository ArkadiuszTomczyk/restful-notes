package com.restful.notes.restfulnotes.web.controller;

import com.restful.notes.restfulnotes.service.NoteService;
import com.restful.notes.restfulnotes.web.model.NoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/notes")
public class NoteRestController {

    private static final Logger LOGGER = Logger.getLogger(NoteRestController.class.getName());
    @Autowired
    private NoteService noteService;
    //todo przenieśc metodę sign-up do oddzielnego kontrolera - NoteUserRestController - ok

    @GetMapping
    public List<NoteModel> notes() {
        //Design pattern "Delegate" here
        return noteService.notes();
    }

    //@GetMapping("/{id}")
    //@ResponseBody
    //longer version
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteModel note(@PathVariable Long id){
        LOGGER.info("no " + id);
        return noteService.note(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public NoteModel save(@RequestBody NoteModel noteModel){

        LOGGER.info("#### " + noteModel);
        return noteService.save(noteModel) ;
    }

    @PutMapping
    @ResponseBody
    public NoteModel update(@RequestBody NoteModel noteModel){
        LOGGER.info("### "+ noteModel);
        return noteService.update(noteModel);

    }

    @DeleteMapping("/{id}")
    //dopiero po dodaniu value = ... zaczęło działąć
    public void delete(@PathVariable("id") Long id ) {
        noteService.delete(id);
    }
    //todo delete - przetestować czy działa poprawnie- ok
    // todo testy jednostkowe
}
//S.O.L.I.D.
//S- single responsibility
//controller, service, repository sa zgodne z single responsibility