package com.example.demo.rent;


//import java.util.ArrayList;

import com.example.demo.books.Book;
import com.example.demo.users.User;

public class Rent {
	private User user;
	private Book book;
	private String Date;
//	private ArrayList<Theme> rentedBooks = new ArrayList<>();
	
	public Rent(User user, Book book, String date) {
		super();
		this.user = user;
		this.book = book;
		this.Date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "The user=" + user + ",Rented this book=" + book + ", Date=" + Date + "]";
	}

	
	
	
	
}
