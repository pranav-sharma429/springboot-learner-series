package com.nisha.librarymanager;

import com.nisha.librarymanager.dto.BookRequest;
import com.nisha.librarymanager.entity.Book;
import com.nisha.librarymanager.service.LibraryDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/db")
public class BookDBController {

    @Autowired
    LibraryDBService libraryDBService;

    @GetMapping("/books")
    List<Book> getAllBooks() {
        List<Book> allBooks = libraryDBService.getAllBooks();
        return allBooks;
    }

    @GetMapping("/books/{ISBN}")
    ResponseEntity getABook(@PathVariable("ISBN") String isbn) {
        Optional<Book> bookOptional = libraryDBService.getBook(isbn);
        ResponseEntity responseEntity;
        if(bookOptional.isPresent()) {
            responseEntity = new ResponseEntity(bookOptional.get(), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/books")
    Book createBook(@RequestBody BookRequest bookRequest) {
        Book book = libraryDBService.createBook(bookRequest);
        return book;
    }

    @GetMapping("/books/lang/{lang}")
    List<Book> getBookByLang(@PathVariable("lang") String lang) {
        return libraryDBService.getBookByLang(lang);
    }
}
