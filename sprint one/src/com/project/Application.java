package com.project;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Abdulkhalek Alalimi , Monzer Othman , Mohammed Qassem , Osama Alrohani
 * 
 */
public class Application {

	public static void main(String[] args) {

		
		Scanner getter = new Scanner(System.in);
		String name = "Monzer";
		String mobileNumber = "01088888888";
		String email = "dev20@gmail.com";
		String password = "123456789";
		DrivingLicence licence = new DrivingLicence("Egypt","0232354624154",name);
		Vehicle car = new Car("selver","234|dsc","Hyundai Sonata 2010");
		User driver = new Driver(name,mobileNumber,email,password,car,licence);
		Controller controller = new Controller();
		
		// ***************** register new Driver *********
		
		String response = controller.register(driver);
		System.out.println(response);
		String [] favoriteArea= {"Dokki" , "UNI" , "cairo" , "october"};
		((Driver)driver).setFavoriteArea(favoriteArea);
//		((Driver)driver).setRate(0);
		// ***************************
		
		
		System.out.println("************");
		// Check login of a new driver who's not approved yet 
		driver = controller.login(driver.getMobileNumber(),driver.getPassword());

		
		
		// *********************
		
		// registering a new driver 
		System.out.println("*********** a new driver in the system **********");
		name = "Osama";
		mobileNumber = "010883348899";
		email = "dev20@gmail.com";
		password = "123456daf";
		 licence = new DrivingLicence("Egypt","0290323624154",name);
		car = new Car("selver","271|dzvs","Kia Sportage 2019");
		User driver1 = new Driver(name,mobileNumber,email,password,car,licence);
		((Driver)driver1).setFavoriteArea(favoriteArea);
		response = controller.register(driver1);
		System.out.println(response);
		
		
		
		// *************************
		
		 name = "Mohammed";
		 mobileNumber = "01088888899";
		 email = "dev20@gmail.com";
		 password = "123456789";
		System.out.println("**************register a new normal client************"); 
		User client = new Client(name,mobileNumber,email,password);
		response = controller.register(client);
		System.out.println(response);
		// login the new client 
		client = controller.login(client.getMobileNumber(),client.getPassword());
		
		
//		******************************************
		
		
		System.out.println("**************register an admin************");
		
		name = "Alimi";
		mobileNumber = "01088888779";
		email = "dev20@gmail.com";
		password = "123456789";
		
		User admin = new Admin(name,mobileNumber,email,password);
		response = controller.register(admin);
		System.out.println(response);
		
		admin = controller.login(admin.getMobileNumber(),admin.getPassword());
		
		// ***************** 
		System.out.println("Trying to approve a nromal client");
		response = ((Admin) admin).pine(client);
		System.out.println(response);
		
//				***************************
		
		System.out.println("**************trying to approve a driver************"); 
		
		response = ((Admin) admin).approveUser(driver);
		System.out.println(response);
		
		response = ((Admin) admin).approveUser(driver1);
		System.out.println(response);
		
		// ***************************
		System.out.println("**************trying to loggin a driver************");
		driver = controller.login(driver.getMobileNumber(),driver.getPassword());
		
		
		
		
		// register new client with the same number of another client 
		 name = "mohammed";
		 mobileNumber = "01088888899";
		 email = "dev20@gmail.com";
		 password = "123456789";
		System.out.println("**************register a new normal client************"); 
		client = new Client(name,mobileNumber,email,password);
		response = controller.register(client);
		System.out.println(response);
		// **********************************
		System.out.println("Making a trip for our client");
		Ride ride = new Ride(); 
		String source = "Dokki", destination = "UNI";
		ride.setSource(source);
		ride.setDestination(destination);
		System.out.println("Choose your driver with the number of the driver, Please ");
		Map<String , User> tripMade = controller.makeTrip(client, ride);
		if (tripMade!=null) {
			User tripDriver = new Driver();
			System.out.println("Choose the phone number of the driver ");
			String choose = getter.nextLine();
			tripDriver = tripMade.get(choose);
			System.out.println("How would you rate this trip ?" + tripDriver.getName() + ", press from 1 to 5");
			int rate = getter.nextInt();
			((Driver)driver).addRate(client.getName(),rate);
		}
		
		System.out.println("Thanks to use our service.");
		getter.close();
		
	}
	

}
