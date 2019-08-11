package com.restful.notes.restfulnotes.web.controller;

import javafx.application.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 1.
 * Testing the whole application with HTTP server running.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteRestControllerHttpTest {
}
