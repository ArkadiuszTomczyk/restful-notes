package com.restful.notes.restfulnotes;

import com.restful.notes.restfulnotes.dao.entity.NoteEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.restful.notes.restfulnotes.dao"})
public class RestfulNotesApplication {
	NoteEntity noteEntity = new NoteEntity();

	public static void main(String[] args) {
		SpringApplication.run(RestfulNotesApplication.class, args);
	}
	
}
//todo popatrzec na data sql
