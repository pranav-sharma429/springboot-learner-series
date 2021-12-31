package com.nisha.librarymanager.repo;

import com.nisha.librarymanager.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
