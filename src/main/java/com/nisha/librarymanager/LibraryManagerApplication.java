package com.nisha.librarymanager;

import com.nisha.librarymanager.service.LibraryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagerApplication.class, args);
	}

//	@Bean
//	LibraryService libraryService() {
//		return new LibraryService();
//	}
//
//	@Bean
//	StudentService studentService() {
//		return new StudentService();
//	}

	// When we don't have access to source code
	@Bean
	StringUtils stringUtils() {
		return new StringUtils();
	}
}
