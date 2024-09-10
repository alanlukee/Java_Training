package Multimedia_Library_System;

public class MediaLibrary {
	
	
	MediaLibrary(){
		
	}
	
	public void displayContentDetails(int contentId ) {
		
		if (contentId==1) {
			System.out.println("Book having title XYZ");	
		}
		else if(contentId==2){
			System.out.println("Video having title ABC");
		}
		else if(contentId==3){
			System.out.println("Music having title PQR");
		}
		else {
			System.out.println("invalid contentID");
		}
		
		
	}
	
	public void displayContentDetails(int contentId, int userId ) {
		
		if (contentId==1) {
			System.out.println("Person with userid "+userId+" took "+"book having title XYZ");	
		}
		else if(contentId==2){
			System.out.println("Person with userid "+userId+" took "+"video having title ABC");
		}
		else if(contentId==3){
			System.out.println("Person with userid "+userId+" took "+"music having title PQR");
		}
		else {
			System.out.println("invalid contentID");
		}
		
	}
	
	public void displayContentDetails(int contentId, int userId, int duration ) {
		if (contentId==1) {
			System.out.println("Person with userid "+userId+" took "+"book having title XYZ"+" for "+duration+" days");	
		}
		else if(contentId==2){
			System.out.println("Person with userid "+userId+" took "+"video having title ABC"+" for "+duration+" days");
		}
		else if(contentId==3){
			System.out.println("Person with userid "+userId+" took "+"music having title PQR"+" for "+duration+" days");
		}
		else {
			System.out.println("invalid contentID");
		}
		
	}
	

}
