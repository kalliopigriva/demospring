package com.example.demo;
//
//import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.themes.Theme;
import com.example.demo.themes.ThemeServices;
import com.example.demo.users.User;
import com.example.demo.users.UserServices;
import com.example.demo.authors.Author;
import com.example.demo.authors.AuthorServices;
import com.example.demo.books.Book;
import com.example.demo.books.BookServices;
import com.example.demo.rent.Rent;
import com.example.demo.rent.RentServices;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		
		
		
	}

}
