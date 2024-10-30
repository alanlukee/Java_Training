package eval;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public FormEvent(Object source, String name,String email,String phone, String address ) {
		super(source);
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setAddress(address);
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
