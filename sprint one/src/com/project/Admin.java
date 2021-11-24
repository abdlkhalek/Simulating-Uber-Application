package com.project;

/**
 * Admin class which is a user with some Extra functions.
 **/ 
public class Admin extends User implements IAdmin{
	
	/**
	 * <h1>Admin Constructor</h1>
	 * which will set the attributes for the instance
	 * <p>
	 * 
	 * @param name , mobileNumber , email , password
	 **/
	public Admin(String name , String mobileNumber, String email,String password) {
		super(name,mobileNumber,email,password); // using super class constructor 
	}
	
	/**
	 * <h1>approveDriver</h1>
	 * Which allows admin to approve driver with correct data.
	 * <p>
	 * @param driver 
	 * @return string 
	 **/
	@Override
	public String approveUser(User user) {
		if (user instanceof Client) {
			((Client) Controller.getUser(user.getMobileNumber())).setPinned(false);
		}
		else {
			((Driver) Controller.getUser(user.getMobileNumber())).setPinned(false);
		}
		return user.getName() + " BEEN pinned SUCCESSFULLY";
	}

	/**
	 * <h1>pine</h1>
	 * Which allows admin to pine driver.
	 * <p>
	 * @param driver 
	 * @return string
	 **/
	@Override
	public String pine(User user) {
		if (user instanceof Client) {
			((Client) Controller.getUser(user.getMobileNumber())).setPinned(true);
		}
		else {
			((Driver) Controller.getUser(user.getMobileNumber())).setPinned(true);
		}
		return user.getName() + " BEEN pinned SUCCESSFULLY";
	}
}
