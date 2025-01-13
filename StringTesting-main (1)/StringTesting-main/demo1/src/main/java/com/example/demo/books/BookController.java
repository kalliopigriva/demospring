package com.example.demo.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authors.Author;
import com.example.demo.themes.Theme;

@RestController
@RequestMapping("books")
public class BookController {
	@Autowired
	BookServices bookServices;

 	@GetMapping("/hello")
	public String hello() {
		return "Hello! :)";
	}

 	@GetMapping("/allbooks")
	public List<Book> getBooksAll() {
 		bookServices.viewAllBooks();
		return bookServices.getBooks();
	}
 	
 	@PostMapping("/add")
	public List<Book> addBook(@RequestBody Book book) {
		return bookServices.addBook(book);
	}
 	
 	@DeleteMapping("/delete")
	public List<Book> deleteBook(@RequestParam Integer id ) {
		return bookServices.removeBook(id);
	}
 	
 	@PutMapping("/update")
	public List<Book> updateBook(@RequestParam Integer id, @RequestParam(required = false) String newTitle, @RequestParam(required = false) Author newAuthor, @RequestParam(required = false) String newPublisher, @RequestParam(required = false) Integer newYear,
			@RequestParam(required = false) String newDesc, @RequestParam(required = false) ArrayList<Theme> newThemes) {
		return bookServices.updateBook(id, newTitle, newAuthor, newPublisher, newYear, newDesc, newThemes);
	}
 	
 		 
// 	@PutMapping("/update")
//	public List<Book> updateBook(@RequestParam Integer id, @RequestParam(required = false) String newTitle, @RequestParam(required = false) Author newAuthor, @RequestParam(required = false) String newPublisher, @RequestParam(required = false) Integer newYear,
//			@RequestParam(required = false) String newDesc, @RequestParam(required = false) ArrayList<Theme> newThemes) {
//		return bookServices.updateBook(id, newTitle, newAuthor, newPublisher, newYear, newDesc, newThemes);
//	}
 	
 	@PutMapping("/updateBookAuthor")
	public List<Book> updateBookAuthor(@RequestParam Integer idBook,Integer idAuthor) {
		return bookServices.updateBookAuthor(idBook, idAuthor);
	}
 	
 	
 	@PostMapping("/addBookTheme")
	public List<Book> addBookTheme(@RequestParam Integer idBook,Integer idTheme) {
		return bookServices.addBookTheme(idBook, idTheme);
	}
}
