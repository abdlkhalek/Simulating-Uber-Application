package com.project;

import java.util.Map;

// the subject which will add 
public class Controller implements ITransport{ // StoragePersistence

	private static final StorageService store = Storage.getInstance();
	protected static final  UserValidator validator = new UserValidator();
	
	public static void save(User user) {
		store.store(user);
	}
	
	public static User getUser(String mobileNumber) {
		return store.getUser(mobileNumber);
	}

	@Override
	public String register(User user) {
		boolean validUser = Controller.validator.validate(user);
		// mobile number can only assigned to one user.
		if (store.getUser(user.getMobileNumber())!= null) {
			return "THIS USER IS ALREADY EXIST.";
		}
		if(!validUser) {
			return "INVALID DATA";
		}
	    // if driver
		if (user instanceof Driver) {
			((Driver) user).setPinned(true);// setting the driver to be pinned in the beginning.
			System.out.print("WATING FOR THE ADMIN TO APPROVE YOUR DATA, ");
		}
		Controller.save(user);
		return "YOU BEEN REGISTERED SUCCESSFULLY";
	}

	@Override
	public User login(String mobileNumber, String password) {
		User loggedUser = store.getUser(mobileNumber);

		if(loggedUser != null && password.trim()!=loggedUser.getPassword() ) {
			System.err.println("INVALID DATA");
			return null;
		}
		if (loggedUser instanceof Driver && ((Driver)loggedUser).isPinned()) {
			System.err.println("YOU CAN'T LOGGIN TO YOUR ACCOUNT YET,UNTIL ADMIN APPROVE YOUR DATA");
			return loggedUser; // null i think
		}
		System.out.println("Welcome Back " + loggedUser.getName());
		return loggedUser;
	}
	
	@Override
	public void removeUser(User user) {
		store.delete(user);
	}

	@Override
	public Map<String,User> makeTrip(User user , Ride ride) {
		return ((Storage)store).search(user , ride);
	}	
	
	
	
}
