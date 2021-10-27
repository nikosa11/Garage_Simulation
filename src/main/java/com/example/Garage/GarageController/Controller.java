package com.example.Garage.GarageController;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.Garage.Service.GarageService;
import com.example.Garage.Service.ValidationService;
import com.example.Garage.model.Car;
import com.example.Garage.model.Driver;
import com.example.Garage.model.Motorcycle;
import com.example.Garage.model.Reservation;
import com.example.Garage.model.Staff;
import com.example.Garage.model.Vehicle;
import com.example.Garage.model.VehicleType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Controller {
	
	GarageService garageService =new GarageService();
	@Autowired
	ValidationService validationService;
	ArrayList<Integer> activePlateNumbers=new ArrayList<Integer>();
	ArrayList<String> activeNames=new ArrayList<String>();

	static Log log = LogFactory.getLog(Controller.class);
	
	public Vehicle createVehicle(Integer plateNumber,VehicleType vehicleType) throws Exception{
		
		try {
			if(plateNumber==null) {
				throw new Exception("The plate Number is null");
			}
		for(Integer activePlateNumber:activePlateNumbers) {
			

			if(activePlateNumber.equals(plateNumber)) {

			throw new Exception("A Vehicle whith that plate Number already exist");	
			}
			
		}
		}catch(Exception e) {
			log.info(e);
            return null;
            }
		activePlateNumbers.add(plateNumber);
		if(vehicleType==VehicleType.CAR) {
			return new Car(plateNumber);}
		return new Motorcycle(plateNumber);

		
	}
	
	public Driver createDriver(String name){
		try {
			if(!ValidationService.isValid(name)) {
				throw new Exception("Invalid name");
			}
			for(String activeName:activeNames) {
				if(activeName.equals(name)) {
					throw new Exception("The Driver Name Already Exist");

				}
			}
			
		}catch(Exception e) {
			log.info(e);
			return null;
			}
		activeNames.add(name);
		return new Driver(name);
	}
	
	public Staff createStaff(String name){
		try {
			if(!ValidationService.isValid(name)) {
				throw new Exception("Invalid name");
			}
			
		}catch(Exception e) {
			log.info(e);
			return null;
			}
		return new Staff(name);
	}

	
	public Reservation createReservation(Driver driver,Integer plateNumber,Staff staff){
		VehicleType vehicleType =driver.returnTheType(plateNumber);

		try {
			

			if(driver==null||plateNumber==null||staff==null||vehicleType==null) {
				throw new Exception("invalid Reservation");
			}
			
		}catch(Exception e) {
			
			log.info(e);
			return null;
		}
		Reservation reservation= new Reservation(driver,plateNumber,staff,vehicleType);		
		garageService.newReservation(reservation);
		return reservation;

	}
	
	
	public void addCarInDriver(Driver driver,Vehicle vehicle) {
		try {
		if (vehicle==null||driver==null) {
			throw new Exception("There are null objects");	
		}
		}
		catch(Exception e) {
			log.info(e);
		}
		if(!vehicle.hasOwner()) {
			driver.setVehicle(vehicle);
			vehicle.changeStatusToTrue();
		}
		else {
			log.info("that vehicle has akready owner");
		}
	}
	
	public void garageAvailabillity() {
		garageService.giveMeTheAvailability();
		garageService.returnTheActiveReservations();
	}
	public double returnTheTotalCost() {
		log.info("total cost ");
		log.info(garageService.getTotalCost());
		return garageService.getTotalCost();
	}
	
	public void staffActiveReservationsDetails(String staffName) {
		log.info("The Details of");
		log.info(staffName);
		garageService.giveMeStaffDetails(staffName);
	}
	
	public void closeTheReservation(Reservation reservation) {
		log.info("Remove a Reservation");
		garageService.newAvailableSeat(reservation);
		garageAvailabillity();
		returnTheTotalCost();
		
	}

}
