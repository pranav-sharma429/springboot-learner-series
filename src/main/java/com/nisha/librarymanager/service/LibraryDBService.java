package com.nisha.librarymanager.service;

import com.nisha.librarymanager.entity.Book;
import com.nisha.librarymanager.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryDBService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}
