package com.nisha.librarymanager.service;

import com.nisha.librarymanager.dto.Book;
import com.nisha.librarymanager.dto.BookRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class LibraryService {

    List<Book> bookList;

    public List<Book> getAllBooks() {
        return bookList;
    }

    public List<Book> getBooks(String genre, String language, String name) {
        List<Book> result = new ArrayList<>();

        for(Book book : bookList) {
            if(book.getLang().equals(language)) {
                if (book.getGenre().equals(genre) && book.getName().contains(name)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public Optional<Book> getBook(String ISBN) {
        Optional<Book> resultBook = Optional.empty();

        for(Book book : bookList) {
           if(book.getISBN().equalsIgnoreCase(ISBN)){
               resultBook = Optional.of(book);
               break;
           }
        }
        return resultBook;
    }

    // DTO -> BookRequest
    public Book createBook(BookRequest bookRequest) {
        int newISBN = bookList.size() + 1;
        String ISBN = "ISBN00" + newISBN;

        Book book = new Book(ISBN, bookRequest.getName(), bookRequest.getAuthor(),
                bookRequest.getTotalPages(), bookRequest.getGenre(), bookRequest.getLang());

        bookList.add(book);

        return book;
    }

    public boolean updateBook(String isbn, BookRequest bookRequest) {
        boolean updated = false;

        // Enhanced For Loop -> Only for read & update
        for(Book book: bookList) {
            // ConcurrentModificationException
             bookList.remove(book);
            if(book.getISBN().equalsIgnoreCase(isbn)) {
                book.setGenre(bookRequest.getGenre());
                book.setTotalPages(bookRequest.getTotalPages());
                book.setName(bookRequest.getName());
                book.setAuthor(bookRequest.getAuthor());
                updated = true;
            }
        }

        return updated;
    }

    public boolean deleteBook(String isbn) {
        boolean isDeleted = false;
        // Delete in For Loop -> Iterator
        Iterator<Book> it = bookList.iterator();

        while(it.hasNext()) {
            Book book = it.next();
            if(book.getISBN().equalsIgnoreCase(isbn)) {
                it.remove();
                isDeleted = true;
            }
        }

        return isDeleted;
    }

    @PostConstruct
    public void init() {
        System.out.println("Init function called automatically");
        Book b1 =  new Book("ISBN001", "Ponniyin Selvan", "Kalki", 2300, "Historic", "TA");
        Book b2 =  new Book("ISBN002", "My Experiment with Truth", "Gandhi", 1500, "Biography", "EN");
        Book b3 =  new Book("ISBN003", "My Experiment with Karma 2", "Gandhi", 1500, "Biography", "GA");
        Book b4 =  new Book("ISBN004", "Bhagavat Gita", "Krishna", 350, "Divine", "TA");
        Book b5 =  new Book("ISBN005", "Big Bang Theory", "Maxwell", 250, "SciFi", "EN");
        Book b6 =  new Book("ISBN006", "Time", "Stephen Hawking", 200, "SciFi", "EN");

        bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
    }
}
