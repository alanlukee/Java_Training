package ContactManager;



//name, phoneNumber, and email

public class Contact  {
	private int contactId;
	private String name;
	private String phoneNumber;
	private String email;
	
	Contact(int contactId, String name,String phoneNumber, String email ){
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	public String toString() {
		return ("Contact details: Name: "+name+", Phone number: "+phoneNumber+", Email: "+email);
	}
	
	public int hashCode() {
		return contactId;
	}
	
	public boolean equals(Object o) {
		
		if(this==o)
		return true;
		
		if(o instanceof Contact) {
			
			Contact s2=(Contact)o;
			
		if(    name.equals(s2.name) && phoneNumber.equals(s2.phoneNumber) && email.equals(s2.email)   ) {
			return true;
		}
		else
			return false;
		}
		return false;
		}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public int getContactId() {
		return contactId;
	}


	public void setContactId(int contactId) {
		this.contactId = contactId;
	}





	
	

}
