package com.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
*	driver which is a user also with some extra needed attributes, which is also the observer  
*/ 
public class Driver extends User implements IDriver{

	// driver attributes
	private DrivingLicence licence;
	private long nationalID;
	private String favoriteArea[];
	Ride ride;
	private Map<String,Integer> rates;
	private  int numberOfRides;
	private Vehicle vehicle;
	
	private boolean pinned ; // active or not 
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <h1>Admin Constructor</h1>
	 * which will set the attributes for the instance
	 * <p>
	 * 
	 * @param name , mobileNumber , email , password , DriveingLicence
	 **/
	public Driver(String name , String mobileNumber,String email,String password,Vehicle vehicle,DrivingLicence licence) {
		super(name,mobileNumber, email,password);
		rates = new HashMap<>();
		licence.setCountry(licence.getCountry());
		licence.setDriverName(licence.getDriverName());
		licence.setLicenceNumber(licence.getLicenceNumber());
		setVehicle(vehicle);
	}
	
	/**
	 * <h1>Licence getter</h1>
	 * which will get the licence
	 * <p>
	 * 
	 * @return licence
	 **/
	public DrivingLicence getLicence() {
		return licence;
	}
	
	/**
	 * <h1>Licence setter</h1>
	 * which will set the licence
	 * <p>
	 * 
	 * @param licence
	 **/
	public void setLicence(DrivingLicence licence) {
		this.licence = licence;
	}
	
	/**
	 * <h1>nationlaID getter</h1>
	 * which will get the nationalId
	 * <p>
	 * 
	 * @return nationalId
	 **/
	public long getNationalID() {
		return nationalID;
	}
	
	/**
	 * <h1>nationalId setter</h1>
	 * which will set the nationalId
	 * <p>
	 * 
	 * @param nationalID
	 **/
	public void setNationalID(long nationalID) {
		this.nationalID = nationalID;
	}
	
	/**
	 * <h1>favoriteArea getter</h1>
	 * which will get the favoriteArea
	 * <p>
	 * 
	 * @return favoriteArea
	 **/
	public String[] getFavoriteArea() {
		return favoriteArea;
	}
	
	/**
	 * <h1>favoriteArea setter</h1>
	 * which will set the favoriteArea
	 * <p>
	 * 
	 * @param favoriteArea
	 **/
	public void setFavoriteArea(String[] favoritArea) {
		this.favoriteArea = favoritArea;
	}
	
	/**
	 * <h1>pinned getter</h1>
	 * which will get the pinned or not
	 * <p>
	 * 
	 * @return pinned
	 **/
	public boolean isPinned() {
		return pinned;
	}
	
	/**
	 * <h1>pined setter</h1>
	 * which will set the pinned
	 * <p>
	 * 
	 * @param pinned
	 **/
	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	public int getNumberOfRides() {
		return numberOfRides;
	}
	public void setNumberOfRides(int numberOfRides) {
		this.numberOfRides = numberOfRides;
	}
	
	
	public void addRate( String name , int rate) {
		rates.put(name, rate);
	}
	
	public int getRates() {
		int value =0 ;
		for (Map.Entry<String, Integer> entry : rates.entrySet()) {
			value+=entry.getValue();
		}
		return rates.size()<=0 ? 0 : value/rates.size();
	}
	
	
	public Ride getRide() {
		return ride;
	}
	public void setRide(Ride ride) {
		this.ride = ride;
	}
	@Override
	public void update(User user , Ride ride ) {
		
		if(Arrays.asList(favoriteArea).contains(ride.getSource())) {
			System.out.println(
					"Dear " + user.getName() + 
					" Captain " + this.getName() + " is in the same area if you like the price , with " +  vehicle.getColor() + " " +vehicle.getModel()  
					 + " and plate number " + vehicle.getPlateNumber() + " ,mobileNumber " +  
							this.getMobileNumber() + "Rated " + this.getRates()
					);
			numberOfRides++;
			return;
		}
		System.out.println("no captain near to this area at the moment, try later, Thanks to use our service");
	}
	
}
