package com.example.libary.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    // title,author,description
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Strg +Leertaste (2mal) vor Autovervollständiung um
                                                        // Beschreibung zu erhalten
    private Long id;
    private String title;
    private String author;
    private String description;

    public Book() {

    }

    public Book(String title, String author, String description) {
        this.author = author;
        this.description = description;
        this.title = title;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Vielleicht so formatieren:
    // Book [ID: 5, Title: "asdasd", Author: "asdasd"]
    @Override
    public String toString() {
        return String.format("{ \"id\": %s, \"title\": \"%s\", \"author\": \"%s\" }", id, title, author);
        // return "[title: " + title + "," + " author: " + author +"]";
    }

}
