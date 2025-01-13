package com.example.demo.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.authors.Author;
import com.example.demo.authors.AuthorServices;
import com.example.demo.themes.Theme;
import com.example.demo.themes.ThemeServices;


@Service
public class BookServices {

	@Autowired
	ThemeServices themeServices;
	@Autowired
	AuthorServices authorServices;
	private List<Book> books = new ArrayList<Book>();

	public BookServices(ThemeServices themeServices, AuthorServices authorServices) {
		this.authorServices = authorServices;
		this.themeServices = themeServices;
	}

	public void viewAllBooks() {
		if (books.isEmpty()) {
			System.out.println("There are no books.");
		} else {
			System.out.println("Books: ");
			for (Book book : books) {
				System.out.println(book);
			}
		}
	}

	public List<Book> getBooks() {
		return books;
	}


	public List<Book> addBook(Book book) {
		System.out.println("Adding book : " + "'" + book.getTitle() + "'");
		books.add(book);
		return books;
	}

	public List<Book> removeBook(int id) {
		books.removeIf(book -> book.getId() == id);
		return books;
	}

	public List<Book> updateBook(int id, String newTitle, Author newAuthor, String newPublisher, Integer newYear,
			String newDesc, ArrayList<Theme> newThemes) {
		for (Book book : books) {
			if (id == book.getId()) {
				if (newTitle != null)
					book.setTitle(newTitle);
				if (newAuthor != null)
					book.setAuthor(newAuthor);
				if (newPublisher != null)
					book.setPublisher(newPublisher);
				if (newYear!= null && newYear > 0)
					book.setPublishedYear(newYear);
				if (newDesc != null)
					book.setDescription(newDesc);
				if (newThemes != null)
					book.setThemes(newThemes);
			}
		}
		return books;
	}

	public List<Book> updateBookAuthor(int idBook, int idAuthor) {
		for (Book book : books) {
			if (idBook == book.getId()) {
				for (Author author : authorServices.getAuthors()) {
					if (author.getId() == idAuthor) {
						book.setAuthor(author);
						// break;
					}
				}
				// authors.setAuthor();
			}
		}
		return books;
	}

	public List<Book> addBookTheme(int idBook, int idTheme) {
		for (Book book : books) {
			if (idBook == book.getId()) {
				for (Theme theme : themeServices.getThemes()) {
					if (theme.getId() == idTheme) {
						book.addTheme(theme);
					}
				}
			}
		}
		return books;
	}
	
//	public void rentBook(int idBook) {
//		for (Book book : RentedBooks) {
//			if (idBook == book.getId()) 
//				System.out.println("You can't rent this book, someone else has rent it! :( ");
//			else
//				RentedBooks.add(book);				
//			}
//	}
//	
//	public void returnBook(int idBook) {
//		for (Book book : RentedBooks) {
//			if (idBook == book.getId()) 
//				RentedBooks.remove(book);				
//			}
//	}


}
