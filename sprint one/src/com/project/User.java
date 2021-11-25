package com.project;



public abstract class User {

	// user's attributes
	private String name;
	private String mobileNumber;
	private String email;
	private String password;
	
	public User() {}
	
	/**
	 * <h1>User Constructor</h1>
	 * which will set the attributes for the instance
	 * <p>
	 * 
	 * @param name , mobileNumber , email , password
	 **/
	public User(String name , String mobileNumber, String email,String password) {
		setName(name);
		setMobileNumber(mobileNumber);
		setEmail(email);
		setPassword(password);
	}
	
	/**
	 * <h1>Name getter </h1>
	 * which will get the name of the user 
	 * <p>
	 * @return name
	 **/
	public String getName() {
		return name;
	}
	/**
	 * <h1>Name setter </h1>
	 * which will set the name of the user 
	 * <p>
	 * @param name
	 **/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <h1>mobileNumber getter </h1>
	 * which will get the mobileNumber of the user 
	 * <p>
	 * @return mobileNumber
	 **/
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	/**
	 * <h1>Name setter </h1>
	 * which will set the mobileNumber of the user 
	 * <p>
	 * @param mobileNumber
	 **/
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * <h1>email getter </h1>
	 * which will get the Email of the user 
	 * <p>
	 * @return email
	 **/
	public String getEmail() {
		return email;
	}
	/**
	 * <h1>email setter </h1>
	 * which will set the email of the user 
	 * <p>
	 * @param email
	 **/
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * <h1>password getter </h1>
	 * which will get the password of the user 
	 * <p>
	 * @return password
	 **/
	public String getPassword() {
		return password;
	}
	
	/**
	 * <h1>password setter </h1>
	 * which will set the password of the user 
	 * <p>
	 * @param password
	 **/
	public void setPassword(String password) {
		this.password = password;
	}
	
}
