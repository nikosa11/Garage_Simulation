package com.example.Garage.model;

public class Car implements  Vehicle {
	private Integer plateNumber;
	private boolean reserved=false;
	private boolean status=false;



	public Car(Integer plateNumber) {
		super();
		this.plateNumber = plateNumber;
	}

	public int getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public VehicleType giveMeTheType() {
		return VehicleType.CAR;
	}


	@Override
	public boolean getReserved() {
		return reserved;
	}

	@Override
	public void setReserved(boolean isReserved) {
		this.reserved=isReserved;
		
	}
	@Override
	public boolean hasOwner() {
		return status;
	}



	@Override
	public void changeStatusToTrue() {
		this.status=true;
		
	}

}
