package com.restful.notes.restfulnotes.web.model;

import javax.validation.constraints.Size;

public class NoteUserModel {

    private Long id;
    @Size(min = 3, max = 30, message = "{noteUser.name.size}")
    private String username;
    private String password;

    public NoteUserModel() {
    }

    public NoteUserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NoteUserModel(Long id, @Size(min = 3, max = 30, message = "{noteUser.name.size}") String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    nie było więc dodałem
    @Override
    public String toString() {
        return "NoteUserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
// nie było gettera do Id więc dodałem
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
