package com.example.demo.users;

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
@RequestMapping("users")
public class UserController {
	@Autowired
	UserServices userServices;

 	@GetMapping("/hello")
	public String hello() {
		return "Hello! :)";
	}

 	@GetMapping("/allusers")
	public List<User> getUsersAll() {
		return userServices.getAllUsers();
	}
 	
 	@PostMapping("/add")
	public List<User> addUser(@RequestBody User user) {
		return userServices.addUser(user);
	}
 	
 	@DeleteMapping("/delete")
	public List<User> deleteUser(@RequestParam Integer id ) {
		return userServices.removeUser(id);
	}
 	
// 	@PutMapping("/update")
//	public List<Rent> updateRent(@RequestParam Integer id, String newTitle, Author newAuthor, String newPublisher, int newYear,
//			String newDesc, ArrayList<Theme> newThemes) {
//		return rentServices.updateRentedBook(id, newTitle, newAuthor, newPublisher, newYear, newDesc, newThemes);
//	}
 	
 	
}


