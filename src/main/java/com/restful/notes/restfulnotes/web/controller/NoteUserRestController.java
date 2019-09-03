package com.restful.notes.restfulnotes.web.controller;

import com.restful.notes.restfulnotes.service.NoteUserService;
import com.restful.notes.restfulnotes.web.model.NoteUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class NoteUserRestController {

    @Autowired
    private NoteUserService noteUserService;

    @GetMapping(value = "/sign-up")
    public void  signUp(@RequestBody NoteUserModel noteUserModel) {
        noteUserService.save(noteUserModel);
    }

}
