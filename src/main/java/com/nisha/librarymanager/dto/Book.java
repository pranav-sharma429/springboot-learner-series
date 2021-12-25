package com.nisha.librarymanager.dto;

// POJO -> Plain Old Java Objects
// When u want a java object to store data alone, no operations
// Standards -> all fields/properties should be private & there should be getters & setters -> public
public class Book {
    private String ISBN;
    private String name;
    private Integer totalPages;
    private String author;
    private String genre;
    private String lang;

    public Book(String ISBN, String name, String author, Integer totalPages, String genre, String lang) {
        this.ISBN = ISBN;
        this.name = name;
        this.totalPages = totalPages;
        this.author = author;
        this.genre = genre;
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
