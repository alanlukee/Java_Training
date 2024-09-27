package ContactManager;

class DuplicateContactException extends Exception{
	
	DuplicateContactException(String s){
		super(s);
		
	}
}

class ContactNotFoundException extends Exception{
	ContactNotFoundException(String s){
		super(s);
	}
}