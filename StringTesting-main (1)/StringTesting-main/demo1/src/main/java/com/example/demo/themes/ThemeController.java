package com.example.demo.themes;

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

@RestController
@RequestMapping("themes")
public class ThemeController {
	@Autowired
	ThemeServices themeServices;

 	@GetMapping("/hello")
	public String hello() {
		return "Hello! :)";
	}

 	@GetMapping("/allthemes")
	public List<Theme> getThemesAll() {
		return themeServices.getThemes();
	}
 	
 	@PostMapping("/add")
	public List<Theme> addTheme(@RequestBody Theme theme) {
		return themeServices.addTheme(theme);
	}
 	
 	@PostMapping("/addMany")
	public List<Theme> addManyThemes(@RequestBody List<Theme> themes) {
 		return themeServices.AddManyThemes(themes);
	}
 	
 	@DeleteMapping("/delete")
	public List<Theme> deleteTheme(@RequestParam Integer id ) {
		return themeServices.removeTheme(id);
	}
 	
 	@PutMapping("/update")
	public List<Theme> updateTheme(@RequestParam Integer id ,@RequestParam(required = false) String newName, @RequestParam(required = false) String newDescription ) {
		return themeServices.updateTheme(id, newName, newDescription);
	}
 	
 	
}
