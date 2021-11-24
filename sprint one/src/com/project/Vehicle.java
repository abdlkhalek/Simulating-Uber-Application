package com.project;

public abstract class Vehicle {

	String color ;
	String plateNumber;
	String model;
	
	
	
	public Vehicle(String color, String plateNumber, String model) {
		setColor(color);
		setPlateNumber(plateNumber);
		setModel(model);
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	
}
