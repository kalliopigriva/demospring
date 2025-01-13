package com.example.demo.rent;


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
@RequestMapping("rents")
public class RentController {
	@Autowired
	RentServices rentServices;

 	@GetMapping("/hello")
	public String hello() {
		return "Hello! :)";
	}

 	@GetMapping("/allrents")
	public List<Rent> getRentsAll() {
		return rentServices.getRents();
	}
 	
 	@PostMapping("/add")
	public List<Rent> addRebt(@RequestBody Rent rent) {
		return rentServices.addRentedBook(rent);
	}
 	
 	@DeleteMapping("/delete")
	public List<Rent> deleteRent(@RequestParam Integer id ) {
		return rentServices.removeRentedBook(id);
	}
 	
// 	@PutMapping("/update")
//	public List<Rent> updateRent(@RequestParam Integer id, String newTitle, Author newAuthor, String newPublisher, int newYear,
//			String newDesc, ArrayList<Theme> newThemes) {
//		return rentServices.updateRentedBook(id, newTitle, newAuthor, newPublisher, newYear, newDesc, newThemes);
//	}
 	
 	
}


