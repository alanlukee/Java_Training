package Library;

public class Magazine extends LibraryItem {
	
	private int issueNumber;
	private String publicationDate;
	
	Magazine(String  LibraryItemtitle,String LibraryItemID,int issueNumber,String publicationDate){
		
		super(LibraryItemtitle,LibraryItemID);
		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
	}
	public void getDetails() {
		
        super.getDetails();
        System.out.println("Issue Number " + issueNumber);
        System.out.println("Publication Date: " + publicationDate);
        
	}
	
	public void updatePublicationDate(String newDate) {
		this.publicationDate = newDate;
		System.out.println("Date has been updated to: "+newDate);
	}
	
	

}
