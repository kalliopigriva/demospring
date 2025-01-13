package com.example.demo.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserServices {
	private List<User> users = new ArrayList<User>();

	public void viewAllUsers() {
		if (users.isEmpty()) {
			System.out.println("There are no users.");
		} else {
			System.out.println("Users: ");
			for (User user : users) {
				System.out.println(user);
			}
		}
	}
	
	public List<User> addUser(User user) {
		users.add(user);
		return users;
	}
	
	public List<User> getAllUsers() {
		return users;
	}


	public List<User> removeUser(int id) {
		users.removeIf(user -> user.getId() == id);
		return users;
	}

	public List<User> updateUser(int id, String newFirstName, String newLastName, String newDateOfBirth) {
		for (User user  : users) {
			if (id == user.getId()) {
				if (newFirstName != null)
					user.setFirstName(newFirstName);
				if (newLastName != null)
					user.setLastName(newLastName);
				if (newDateOfBirth != null)
					user.setDateOfBirth(newDateOfBirth);
			}
		}
		return users;
	}
	
}
