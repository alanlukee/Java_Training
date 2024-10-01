package com.concurrentEventManagementSystem;

@SuppressWarnings("serial")
class EventAlreadyCompletedException extends Exception{
	
	EventAlreadyCompletedException(String s){
		super(s);
	}
}

@SuppressWarnings("serial")
class DuplicateEventException extends Exception{
	DuplicateEventException(String s){
		super(s);
	}
}

class NoSuchEvent extends Exception{
	
	NoSuchEvent(String s){
		super(s);
	}
}