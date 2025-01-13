package com.example.demo.authors;


import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
//
//import com.example.demo.books.Book;
//import com.example.demo.themes.Theme;

@Service
public class AuthorServices {

	private List<Author> authors = new ArrayList<Author>();

	public void viewAllAuthors() {
		if (authors.isEmpty()) {
			System.out.println("There are no authors.");
		} else {
			System.out.println("Authors: ");
			for (Author author : authors) {
				System.out.println(author);
			}
		}
	}

	public List<Author> addAuthor(Author author) {
		//System.out.println("Adding author : " + "'" + author.getFirstName() + "'" + "'" + author.getLastName() + "'");
		authors.add(author);
		return authors;
		
	}
	
	
	//events services -> 
	//reservation -> make reservation (eventID ,visitorID)
	// visitor services -> apothikeuei neous visitor, (opos book)
	// visitor -> mono setters getters
	

	

	public List<Author> getAuthors() {
		return authors;
	}


	public List<Author> removeAuthor(int id) {
		authors.removeIf(author -> author.getId() == id);
		return authors;
	}

	public List<Author> updateAuthor(int id, String newFirstName, String newLastName, String newDateOfBirth) {
		for (Author author : authors) {
			if (id == author.getId()) {
				if (newFirstName != null)
					author.setFirstName(newFirstName);
				if (newLastName != null)
					author.setLastName(newLastName);
				if (newDateOfBirth != null)
					author.setDateOfBirth(newDateOfBirth);
			}
		}
		return authors;
	}

}
