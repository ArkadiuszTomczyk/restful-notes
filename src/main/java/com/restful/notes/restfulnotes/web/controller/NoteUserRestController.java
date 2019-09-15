package com.restful.notes.restfulnotes.web.controller;

import com.restful.notes.restfulnotes.service.NoteUserService;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class NoteUserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    @Autowired
    private NoteUserService noteUserService;

    public List<NoteUserModel> noteUsers(){
        return noteUserService.
    }


    @GetMapping(value = "/sign-up")
    public void  signUp(@RequestBody NoteUserModel noteUserModel) {
        noteUserService.save(noteUserModel);
    }

}
