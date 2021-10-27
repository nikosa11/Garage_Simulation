package com.example.Garage.model;

public interface Vehicle {
	 public boolean hasOwner();
	 public void changeStatusToTrue();
	 public VehicleType giveMeTheType();
	 public boolean getReserved();
	 public int getPlateNumber() ;
	 public void setReserved(boolean isReserved);


}
