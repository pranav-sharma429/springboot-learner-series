package com.nisha.librarymanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    // @Id -> Represents Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // By Default Null
    private Integer id;

    private String isbn;
    // VARCHAR2
    private String name;
    //private String author;
    @Column(name = "totalPages")
    // NUMBER
    private Integer pages;
    private String genre;
    private String lang;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonBackReference
    Author author;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
