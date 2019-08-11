package com.restful.notes.restfulnotes.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
//@Table(name = "NOTE", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "ID")
//})
public class NoteEntity implements Serializable {
    @Id
    @GeneratedValue
//   todo info  using below annotations we can't create "id", it is generated automatically

//            (strategy = GenerationType.IDENTITY,
//            generator = "NOTE_ID_GENERATOR")
//    @SequenceGenerator
//            (name = "NOTE_ID_GENERATOR", sequenceName = "NOTE_ID_SEQ")
//    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
//    @Column(name = "Title", unique = false, nullable = false)
    private String title;
//    @Column(name = "CONTENT", unique = false, nullable = false)
    private String content;
//    private LocalDateTime created;
//    private LocalDateTime modified;

    public NoteEntity() {
    }

    public NoteEntity(String title, String content) {
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

//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//    public LocalDateTime getModified() {
//        return modified;
//    }
//
//    public void setModified(LocalDateTime modified) {
//        this.modified = modified;
//    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
//                ", created=" + created +
//                ", modified=" + modified +
                '}';
    }
}
