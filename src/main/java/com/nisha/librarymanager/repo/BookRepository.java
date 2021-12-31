package com.nisha.librarymanager.repo;

import com.nisha.librarymanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// JPA -> Java Object -> Query -> I don't want to type Query
// JPA -> Java Persistence API
// Making my code Database Agnostic (Independent)
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Select * from Book where lang = "";
    // FIND * FROM BOOK WHERE LANG = ""; -> Oracle
    List<Book> findByLang(String lang);

    // Select * from Book where lang = "" and genre = "";
    List<Book> findByLangAndGenre(String lang, String genre);

    // Select * from Book where author = "" and lang = "";
    List<Book> findByAuthorAndLang(String author, String lang);

    // Select * from Book where lang = "" or genre = "";
    List<Book> findByLangOrGenre(String lang, String genre);

    // Select * from Book where name like "% %";
    List<Book> findByNameLike(String name);

    // Select * from Book where isbn= "";
    Optional<Book> findByIsbn(String isbn);

    // select * from Book where lang in ("", "");
    List<Book> findByLangIn(List<String> lang);

    // How to run Native Query/Original Query in JPA
    // Adv -> Custom & Complicated Query is possible
    // DisAdv -> Syntax is DB Specific. DB Migration is impossible
    @Query(value = "SELECT * FROM book WHERE lang=:lang AND genre=:genre", nativeQuery = true)
    List<Book> findBooks(String lang, String genre);
}
