package com.restful.notes.restfulnotes.web.errors;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String message){
        super(message);
    }
}
