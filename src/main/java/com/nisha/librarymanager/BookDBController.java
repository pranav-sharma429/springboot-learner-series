package com.nisha.librarymanager;

import com.nisha.librarymanager.entity.Book;
import com.nisha.librarymanager.service.LibraryDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
