package com.concurrentEventManagementSystem;


class addingEventThread implements Runnable {
	
	private EventManager em;
	private Event e;
	
	public addingEventThread(EventManager em, Event e ) {
		// TODO Auto-generated constructor stub
		
		this.em=em;
		this.e = e;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			em.addEvent(e);
			System.out.println("Event added.");
		} catch (DuplicateEventException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	public EventManager getEm() {
		return em;
	}

	public void setEm(EventManager em) {
		this.em = em;
	}

	public Event getE() {
		return e;
	}

	public void setE(Event e) {
		this.e = e;
	}

	public Integer getEventID() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class markEventCompleteThread implements Runnable{
	
	private EventManager em;
	private Event e;
	
	public markEventCompleteThread(EventManager em, Event e ) {
		// TODO Auto-generated constructor stub
		
		this.em = em;
		this.e = e;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			em.markAsComplete(e);
			System.out.println("Event marked as COMPLETED");
		} catch (EventAlreadyCompletedException | NoSuchEvent e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	public EventManager getEm() {
		return em;
	}


	public void setEm(EventManager em) {
		this.em = em;
	}


	public Event getE() {
		return e;
	}


	public void setE(Event e) {
		this.e = e;
	}
	
}


class displayEventsThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}


