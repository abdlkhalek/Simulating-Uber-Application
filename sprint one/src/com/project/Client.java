package com.project;

public class Client extends User{
	private boolean pinned;
	
	
	public Client(String name, String mobileNumber, String email, String password) {
		super(name, mobileNumber, email, password);
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}
	
	
}
