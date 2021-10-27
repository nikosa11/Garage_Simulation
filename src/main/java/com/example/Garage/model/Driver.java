package com.example.Garage.model;

import java.util.HashSet;
import java.util.Set;

public class Driver {
	String name;
	Set<Vehicle> vehicles= new HashSet<Vehicle>();
	public Driver(String name) {
		super();
		this.name = name;
	}
	public void setVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public int getTheNumberOfVehicles() {
		int number=0;
		if (!vehicles.isEmpty()){
			number=vehicles.size();
		}
		return number;
	}
	public int getTheNumberOfReservedVehicles() {
		int number=0;
		for(Vehicle v :vehicles) {
			if (v.getReserved()) {
				number++;
			}
		}
		return number;
	}
	public boolean existTheVehicle(Vehicle vehicle){
		return vehicles.contains(vehicle);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleType returnTheType(int plateNumber) {
		for(Vehicle v:vehicles) {
			if(v.getPlateNumber()==plateNumber)
				return v.giveMeTheType();
		}
		return null;
	}
	
	

}
