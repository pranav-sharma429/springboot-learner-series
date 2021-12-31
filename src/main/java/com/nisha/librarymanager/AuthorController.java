package com.nisha.librarymanager;

import com.nisha.librarymanager.entity.Author;
import com.nisha.librarymanager.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/author")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
