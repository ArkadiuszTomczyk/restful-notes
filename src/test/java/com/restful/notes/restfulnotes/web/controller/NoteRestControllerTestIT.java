package com.restful.notes.restfulnotes.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/** 2.
 * Testing the application where Spring handles HTTP request and hands it off to controller.
 * Full application stack.
 * Without the need to run the server.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteRestControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void shouldSaveTest() {
//        when
//        this.mockMvc.getDispatcherServlet((put("/notes"))).andDo()
//    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/notes")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("WE HAVE IT"));

    }
}
