package com.restful.notes.restfulnotes.web.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.restful.notes.restfulnotes.dao.NoteRepository;
import com.restful.notes.restfulnotes.service.NoteService;
import com.restful.notes.restfulnotes.web.mapper.NoteMapper;
import com.restful.notes.restfulnotes.web.model.NoteModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 1.
 * Testing the whole application with HTTP server running.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


/**
 * 3.
 * Testing the application where Spring handles HTTP request and hands it off to controller.
 * Only the web layer.
 * Without the need to run the server.
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(NoteController.class)

@RunWith(SpringRunner.class)
@WebMvcTest(NoteRestController.class)
public class NoteRestControllerTest {

    private static final long NOTE_ID = 12L;

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    //private NoteModel noteModel ;
    @MockBean
    private NoteMapper noteMapper;
    @MockBean
    private NoteService noteService;
    @MockBean
    private NoteRepository noteRepository;

    @Test
    public void notes() throws Exception {
        //given
        List<NoteModel> notes = new ArrayList<>();
        notes.add(new NoteModel(12L, "coktent1", "best"));
        notes.add(new NoteModel(158L, "some", "tyson"));
        when(noteService.notes()).thenReturn(notes);

        //when
        ResultActions resultActions = mockMvc.perform(get("/notes"))
                .andDo(print())
                .andExpect(status().isOk());
        String response = resultActions.andReturn().getResponse().getContentAsString();

//      Mockito.when().thenReturn();
        System.out.println("result: " + response);

        //then
        List<NoteModel> responseNotes = new ArrayList<>();
//        responseNotes.add(new NoteModel(12L, "coktent1", "best"));
        com.google.gson.JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(response).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            System.out.println("JsonElement: " + jsonElement);
            final NoteModel noteModel = new Gson().fromJson(jsonElement, NoteModel.class);
            System.out.println("NOteMOdel " + noteModel);
            responseNotes.add(noteModel);

        }
        Assert.assertEquals("response list doesn't match ", notes.size(), responseNotes.size());

    }

    @Test
    public void note() throws Exception {
//        todo zaimplementować analogicznie do metody notes()
//        sprawdzić czy metoda get zwracająca szczegóły notatki o id=12 faktycznie zwróci szczegóły notatki
//        podzielić na sekcje given, when, then
        //given
//        NoteModel notes = new NoteModel(12L,"poi", "yui");
//
//        //when
//        ResultActions resultActions = mockMvc.perform(get("/notes/12"))
//                .andDo(print())
//                .andExpect(status().isOk());
//        String respons = resultActions.andReturn().getResponse().getContentAsString();
//        //then
//        NoteModel responseNotes = new NoteModel();
//        com.google.gson.JsonParser jsonParser = new JsonParser();
//        String jsonElement = jsonParser.parse(respons).getAsString();
//        for(JsonElement jsonElement : jsonElement)

    }

    @Test
    public void save() throws Exception {
        //given
        NoteModel noteModel = new NoteModel(1L, "sunremo", "mikey");

        //when
        mockMvc.perform(post("/notes")
//                    .content("{\"title\": \"godzilldfga\",\"content\": \"what now\"}")
                .content(new Gson().toJson(noteModel))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        //then

    }


    @Test
    public void update() throws Exception {
//        todo analogicznie do save() i note()
//given
        NoteModel noteModel12 = new NoteModel(NOTE_ID, "sunremo", "mikey");
        //when
        mockMvc.perform(post("/notes" + NOTE_ID)
//                    .content("{\"title\": \"godzilldfga\",\"content\": \"what now\"}")
                .content(new Gson().toJson(noteModel12))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        //then

    }

    @Test
    public void delete() {
//        todo analogicznie do note()
        //given
        //when
        //then
    }
}
