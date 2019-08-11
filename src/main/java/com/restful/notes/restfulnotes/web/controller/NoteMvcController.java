package com.restful.notes.restfulnotes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/notes")
public class NoteMvcController { // implements NoteController
    @DeleteMapping("/{id}")
    public String deleteMvc(@PathVariable("id") Long id ) {
        return "notes"; // notes - nazwa plik z HTML, który jest w resources/templates/notes.html
    }
//    todo zrobic metody jak w noteRestController tylko tu ze String zamiast NoteModel
}

//@RestController
//@RequestMapping(value = "/api/notes")

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") Long id ) {
//        noteService.delete(id);
//    }



//@Controller
//@RequestMapping(value = "/api/notes")

//    REST
//    @DeleteMapping("/{id}")
//    @ResponseBody
//    public void deleteRest(@PathVariable("id") Long id ) {
//        noteService.delete(id);
//    }

//    MVC
//    @DeleteMapping("/{id}")
//    public String deleteMvc(@PathVariable("id") Long id ) {
//        return "notes"; // notes - nazwa plik z HTML, który jest w resources/templates/notes.html
//    }