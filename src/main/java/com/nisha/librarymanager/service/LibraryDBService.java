package com.nisha.librarymanager.service;

import com.nisha.librarymanager.dto.BookRequest;
import com.nisha.librarymanager.entity.Author;
import com.nisha.librarymanager.entity.Book;
import com.nisha.librarymanager.repo.AuthorRepository;
import com.nisha.librarymanager.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryDBService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book createBook(BookRequest bookRequest) {

        Integer authorId  = bookRequest.getAuthorId();
        Optional<Author> authorOptional = authorRepository.findById(authorId);

        Book book = new Book();

        if(authorOptional.isPresent()) {
            Author author = authorOptional.get();
            book.setName(bookRequest.getName());
            book.setAuthor(author);
            book.setIsbn(bookRequest.getIsbn());
            book.setLang(bookRequest.getLang());
            book.setPages(bookRequest.getTotalPages());
            book.setGenre(bookRequest.getGenre());

            book = bookRepository.save(book);
        }

        return book;
    }

    public Optional<Book> getBook(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        return book;
    }

    public List<Book> getBookByLang(String lang) {
        List<Book> books = bookRepository.findByLang(lang);
        return books;
    }

}
