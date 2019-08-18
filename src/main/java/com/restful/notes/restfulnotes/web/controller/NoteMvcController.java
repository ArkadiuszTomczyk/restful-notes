package com.restful.notes.restfulnotes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/notes")
public class NoteMvcController { // implements NoteController

    @GetMapping(value = "/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @GetMapping
    public String read(Long id) {
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