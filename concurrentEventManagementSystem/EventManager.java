package com.concurrentEventManagementSystem;

import java.util.concurrent.ConcurrentHashMap;

public class EventManager {
	
	//Add an Event, Mark an Event as Completed:, Display All Events:
	
   ConcurrentHashMap<Integer, Event> events ;
    
   public EventManager() {
	   
	   this.events = new ConcurrentHashMap<>();
   }
   
   public void addEvent(Event addingEventThread) throws DuplicateEventException {
	   boolean foundEvent = false;
	   
	   for(Integer i: events.keySet()) {
		   if(i==addingEventThread.getEventID()) {
			   foundEvent = true;
			   throw new DuplicateEventException("Event already present.");
		   }
	   }
	   if(foundEvent==false) {
		   events.put(addingEventThread.getEventID(), addingEventThread);
	   }

   }

public void markAsComplete(Event e2) throws EventAlreadyCompletedException, NoSuchEvent {
	   
    Event event = events.get(e2.getEventID());
    if (event == null) {
        throw new NoSuchEvent("No such event with ID " + e2.getEventID());
    }
    if (event.getStatus() == Status.COMPLETED) {
        throw new EventAlreadyCompletedException("Event with ID " + e2.getEventID() + " is already marked as COMPLETED.");
    }
    event.setStatus(Status.COMPLETED);
}
   
   public void displayEvents() {
	   
	   if (events.isEmpty()) {
           System.out.println("No events available.");
           return;
       }
	   for(Event e: events.values()) {
		   System.out.println(e);
	   }
   }

}
