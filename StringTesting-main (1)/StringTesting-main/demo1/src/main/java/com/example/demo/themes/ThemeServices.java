package com.example.demo.themes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ThemeServices {
	
	private List<Theme> themes = new ArrayList<Theme>();
	

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public void viewAllThemes() {
		if (themes.isEmpty()) {
			System.out.println("There are no themes.");
			} else {
				System.out.println("Themes: ");
				for (Theme theme : themes) {
					System.out.println(theme.getName());
					}
				}
	}
	
	public List<Theme> addTheme(Theme theme) {
		themes.add(theme);
		return themes;
	}
	
	public List<Theme> AddManyThemes(List<Theme> list) {
		for(Theme theme : list){
 			this.addTheme(theme);
 		}
		return themes;
	}
	
	public List<Theme> removeTheme(int id) {
		themes.removeIf(theme -> theme.getId()  == id);
		return themes;
	}
	
	public List<Theme> updateTheme(int id, String newName, String newDescription) {
		for (Theme theme : themes) {
			if(id == theme.getId()) {
				if(newName != null) 
	        		theme.setName(newName);
				if(newName != null) 
	        		theme.setName(newName);
			}
		}
		return themes;
	}

	@Override
	public String toString() {
		return "ThemeServices [themes=" + themes + "]";
	}
	
	

}
