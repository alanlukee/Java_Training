package Library;

public class LibraryItem {
	
	protected String LibraryItemtitle;
	private String LibraryItemID;
	
	LibraryItem(){
		
		LibraryItemtitle = "Unknown";
		LibraryItemID ="0000";
	}
	
	LibraryItem(String LibraryItemtitle,String LibraryItemID){
		
		this.LibraryItemtitle=LibraryItemtitle ;
		this.LibraryItemID=LibraryItemID;
		
	}
	public void getDetails() {
		System.out.println("Title: "+LibraryItemtitle);
		System.out.println("ID: "+LibraryItemID);
	}
	
	public String getTitle() {
		return LibraryItemtitle;
	}
	
	public String getId() {
		return LibraryItemID;
	}
	
}
