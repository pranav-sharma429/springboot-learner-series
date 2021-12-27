package com.nisha.librarymanager.repo;

import com.nisha.librarymanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
