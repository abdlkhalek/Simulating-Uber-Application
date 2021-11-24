package com.project;

import java.util.Map;

public interface ITransport {

	public String register(User user );
	public User login(String mobileNumber , String password );
	public void removeUser(User user);
	public Map<String,User> makeTrip(User user , Ride ride);
	
}
