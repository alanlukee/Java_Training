package com.gui;

import java.util.EventObject;

public class FormEvent extends EventObject { // to receive the event object when the btn is clicked.
	
	private String name;
	private String occupation;
	
	private int ageCategory;
	private String empCat;
	private String taxId;
	private boolean usCitizen;
	private String gender;
	
//	public FormEvent(Object source) {
//		super(source);
//		// TODO Auto-generated constructor stub
//	}
	
	public FormEvent(Object source, String name, String occupation, int ageCategory, String empCat,String taxId,
			boolean usCitizen, String gender) {
		
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.setEmpCat(empCat);
		this.taxId = taxId;
		this.setUsCitizen(usCitizen);
		this.gender = gender;
				
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(int ageCategory) {
		this.ageCategory = ageCategory;
	}

	public String getEmpCat() {
		return empCat;
	}

	public void setEmpCat(String empCat) {
		this.empCat = empCat;
	}

	public boolean isUsCitizen() {
		return usCitizen;
	}

	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
