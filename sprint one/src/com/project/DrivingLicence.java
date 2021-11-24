package com.project;

public class DrivingLicence {

	private String country;
	private String licenceNumber;
	private String driverName;
	
	public DrivingLicence(String country , String licenceNumber , String driverName) {
		setCountry(country);
		setLicenceNumber(licenceNumber);
		setDriverName(driverName);
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
}
