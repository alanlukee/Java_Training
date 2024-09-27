package ContactManager;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContactManager cm = new ContactManager();
		
		Contact c6 = new Contact(6, "pedri", "9847360480", "pedrigongalez@yahoo.com");
		
		try {
			
			cm.addContact(c6);
			
		} catch (DuplicateContactException e) {
			
			System.out.println(e.getMessage());
		}
		
		cm.displayContacts();
		Contact c = cm.searchContact("pedri");
		System.out.println(c);
		
        Set<Contact> gmailContacts = cm.filterEmail("gmail.com");
        System.out.println("Gmail Contacts: " + gmailContacts);
        Set<Contact> yahooContacts = cm.filterEmail("yahoo.com");
        System.out.println("Yahoo Contacts: " + yahooContacts);
        
        
        System.out.println("  ");
        String s = new String("java");
        System.out.println(s);
	}

}
