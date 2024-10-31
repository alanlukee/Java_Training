package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.gui.FormEvent;

import model.AgeCategory;
import model.Database;
import model.EmployementCategory;
import model.Gender;
import model.Person;

public class Controller {
	
	Database db = new Database();
	
	public List<Person> getPeople(){
		return (db.getPeople());
	}
	
	public void removePerson(int index) {
		db.removePerson(index);
	}
	
	
	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAgeCategory();
		String empcat = ev.getEmpCat();
		boolean isUs  = ev.isUsCitizen();
		String taxId = ev.getTaxId();
		String gender = ev.getGender();
		
		AgeCategory ageCategory = null;
		
		switch(ageCatId) {
		case 0:
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
			
		}
		
		
		EmployementCategory empCategory;
		
		
		if(empcat.equals("employed")) {
			empCategory = EmployementCategory.employed;
		}
		else if(empcat.equals("self-employed")) {
			empCategory = EmployementCategory.selfEmployed;
		}
		else if(empcat.equals("unemployed")) {
			empCategory = EmployementCategory.unEmployed;
		}
		else {
			empCategory = EmployementCategory.other;
			System.err.println(empcat);
		}
		
		Gender genderCat;
		
		if(gender.equals("male")) {
			genderCat = Gender.male;
			
		}
		
		else {
			genderCat = Gender.female;
			
		}

		
		Person person = new Person(name, occupation, ageCategory, empCategory, taxId,isUs, genderCat);
		db.addPerson(person);
		
		
	}
	
	public void saveToFile(File file) throws IOException {
		db.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}

}
