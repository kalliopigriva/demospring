package com.example.demo.rent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.themes.Theme;
import com.example.demo.themes.ThemeServices;
import com.example.demo.authors.AuthorServices;
import com.example.demo.books.Book;
import com.example.demo.books.BookServices;
import com.example.demo.users.User;
import com.example.demo.users.UserServices;


@Service
public class RentServices {

	private List<Rent> RentedBooks = new ArrayList<Rent>();

	@Autowired
	BookServices BookServices;
	@Autowired
	UserServices UserServices;

	public RentServices(BookServices bookServices, UserServices userServices) {
		this.BookServices = bookServices;
		this.UserServices = userServices;

	}

	public void viewAllRentedBooks() {
		if (RentedBooks.isEmpty()) {
			System.out.println("There are no book reservations.");
		} else {
			System.out.println("Book Reservation: ");
			for (Rent rent : RentedBooks) {
				System.out.println(rent);
			}
		}
	}

	public List<Rent> getRents() {
		return RentedBooks;
	}

	public List<Rent> addRentedBook(Rent RentedBook) {
		RentedBooks.add(RentedBook);
		return RentedBooks;
	}
	
	public List<Rent> addRentedBook(User user, Book book) {
		RentedBooks.add(new Rent(user, book, ""));
		return RentedBooks;
	}
	
	public List<Rent> removeRentedBook(int idBook) {
		System.out.println("Book with id " + idBook + " is removed");
		RentedBooks.removeIf(rentedBook -> rentedBook.getBook().getId() == idBook);
		
		return RentedBooks;
	}

	public void rentBook(int idUser, int idBook) {
		for (Book book : BookServices.getBooks()) {
			if (book.getId() == idBook) {
				for (User user : UserServices.getAllUsers()) {
					if (idUser == user.getId()) {
						for (Rent rent : getRents()) {
							if(rent.getBook() == book)
								return;
						}
						addRentedBook(new Rent(user, book, ""));
					}
				}
			}
		}
		
	}

	public void returnBook(int idUser, int idBook) {
		for (User user : UserServices.getAllUsers()) {
			if (idUser == user.getId()) {
				for (Book book : BookServices.getBooks()) {
					if (book.getId() == idBook) {
						removeRentedBook(idBook);
					}
				}
			}
		}
	}

}
