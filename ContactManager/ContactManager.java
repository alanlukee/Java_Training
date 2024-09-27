package ContactManager;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


class MyComparator implements Comparator{

    public int compare(Object o1,Object o2) {
 	   
        Contact c1=(Contact)o1;
        Contact c2=(Contact)o2;
        String s1=c1.getName();
        String s2=c2.getName();
        
        return s1.compareTo(s2);	
        
         }
   }


public class ContactManager  {
	
    TreeSet<Contact> contacts = new TreeSet<Contact>(new MyComparator());
	
	//add contact,
	//remove contact,
	//search contact,
	//diplay contacts,
	//Filter Contacts by Email Domain
	
	ContactManager(){
		
		Contact c1 = new Contact(1, "alan", "9495880774", "alankluke@gmail.com");
		Contact c2 = new Contact(2, "lewa", "9495888472", "robertlewa@yahoo.com");
		Contact c3 = new Contact(3, "gavi", "9495884672", "pablogavi@gmail.com");
		Contact c4 = new Contact(4, "torres","9498993747", "pablotorres@gmail.com");
		Contact c5 = new Contact(5, "lamine", "9846538476", "yamalamine@yahoo.com");
		
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
		contacts.add(c5);

	}
	
	public void addContact(Contact c) throws DuplicateContactException {
		boolean contactFound = false;
		for(Contact i : contacts) {
			if (i.getName().equals(c.getName())){
				contactFound = true;
				throw new DuplicateContactException("Contact already exists.");
				
			}
			
		}
		if(contactFound ==false) {
			contacts.add(c);
			System.out.println("Contact added");
		}
		
	}
	
	public void removeContact(Contact c) throws ContactNotFoundException{
		boolean contactFound = false;
		
		Iterator<Contact> itr = contacts.iterator();
		
		while(itr.hasNext()) {
			Contact i = itr.next();
			if(i.getName().equals(c.getName())) {
				contactFound = true;
				contacts.remove(i);
				System.out.println("Contact removed");
			}	
		}
	
		if(contactFound == false) {
			throw new ContactNotFoundException("Contact not found.");
		}
	}
	
	public Contact searchContact(String name) {
		
		for(Contact i : contacts) {
			if(i.getName().equalsIgnoreCase(name)) {
				System.out.println("contact found");
				return i;
			}
		}
		return null;
		
	}
	
	public void displayContacts() {
		
		for(Contact i: contacts) {
			System.out.println(i.toString());
		}
	}
	
	public Set<Contact> filterEmail(String domain){
		
		Set<Contact> filter = new HashSet<Contact>();
		
		for (Contact i : contacts) {
            if (i.getEmail().endsWith(domain)) {
            	filter.add(i);
            }
        }
        return filter;
    }


}