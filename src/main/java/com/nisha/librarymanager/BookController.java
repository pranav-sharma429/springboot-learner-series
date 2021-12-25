package com.nisha.librarymanager;

import com.nisha.librarymanager.dto.Book;
import com.nisha.librarymanager.dto.BookRequest;
import com.nisha.librarymanager.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/name")
    public String getBookName() {
        return "Ponniyin Selvan";
    }

    @GetMapping("/pages")
    public Integer getBookPages() {
        return 2300;
    }

    @GetMapping("/author")
    public String getBookAuthor() {
        return "Kalki";
    }

    @GetMapping("/book/{ISBN}")
    public ResponseEntity getBook(@PathVariable("ISBN") String ISBN) {

        Optional<Book> bookOptional =  libraryService.getBook(ISBN);
        ResponseEntity responseEntity;
        if(bookOptional.isEmpty()) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Book book = bookOptional.get();
            responseEntity = new ResponseEntity(book, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/books/{lang}")
    public List<Book> getBooks(@PathVariable("lang") String language,
                               @RequestParam("genre") String genre,
                               @RequestParam("name") String name) {

        List<Book> books = libraryService.getBooks(genre, language, name);
        return books;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        List<Book> books = libraryService.getAllBooks();
        return books;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody @Valid BookRequest bookRequest) {
        Book book = libraryService.createBook(bookRequest);
        return book;
    }

    @PutMapping("/books/{ISBN}")
    public ResponseEntity updateBook(@RequestBody @Valid BookRequest bookRequest,
                           @PathVariable("ISBN") String isbn) {
        boolean isUpdated = libraryService.updateBook(isbn, bookRequest);
        ResponseEntity responseEntity;
        if(isUpdated) {
            responseEntity = new ResponseEntity(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/books/{ISBN}")
    public ResponseEntity deleteBook(@PathVariable("ISBN") String isbn) {
        boolean isDeleted = libraryService.deleteBook(isbn);
        ResponseEntity responseEntity;
        if(isDeleted) {
            responseEntity = new ResponseEntity(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/test3")
    public List<String> getNames() {
        List<String> list = new ArrayList<>();
        list.add("Vicky");
        list.add("Vijay");
        return list;
    }

    @GetMapping("/test4")
    public List<Integer> getNumbers() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        return list;
    }
}
