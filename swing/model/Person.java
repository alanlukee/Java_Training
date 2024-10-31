package model;

import java.io.Serializable;

public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private static int count = 0;
	private  int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmployementCategory empCat;
	private String taxId;
	private boolean usCitizen;
	private Gender gender;
	
	
	
	public Person(String name, String occupation, AgeCategory ageCategory,EmployementCategory empCat,
			String taxId, boolean usCitizen, Gender gender  ) {

		this.setName(name);
		this.setOccupation(occupation);
		this.setAgeCategory(ageCategory);
		this.setEmpCat(empCat);
		this.setTaxId(taxId);
		this.setUsCitizen(usCitizen);
		this.setGender(gender);
		this.id = count;
		count++;

	}



	public Person(int size) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
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



	public AgeCategory getAgeCategory() {
		return ageCategory;
	}



	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}



	public EmployementCategory getEmpCat() {
		return empCat;
	}



	public void setEmpCat(EmployementCategory empCat) {
		this.empCat = empCat;
	}



	public String getTaxId() {
		return taxId;
	}



	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}



	public boolean isUsCitizen() {
		return usCitizen;
	}



	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
