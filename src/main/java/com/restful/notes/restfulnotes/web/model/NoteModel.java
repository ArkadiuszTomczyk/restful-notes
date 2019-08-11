package com.restful.notes.restfulnotes.web.model;

public class NoteModel {
    private Long id;
    private String title;
    private String content;

    public NoteModel() {
    }

    public NoteModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoteModel(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    // todo after change to lombok
}
