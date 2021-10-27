package com.example.Garage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Garage.GarageController.Controller;
import com.example.Garage.model.Driver;
import com.example.Garage.model.Reservation;
import com.example.Garage.model.Staff;
import com.example.Garage.model.Vehicle;
import com.example.Garage.model.VehicleType;

@SpringBootTest
class GarageApplicationTests {
	Controller controller=new Controller();
	//MAX 10 SPOTS
	//COST CAR:10/H
	//COST MOTORCYCLE 5/H
	//THE PROGRAMM CHARGE FINE , IF YOU WANT TO TEST IT, PUT A FIX TIME IN GARAGE SERVICE FILE

	@Test
	void contextLoads() throws Exception  {

		Vehicle vehicle1;
		Vehicle vehicle2;
		Vehicle vehicle3;
		Vehicle vehicle4;
		Vehicle vehicle5;
		Vehicle vehicle6;
		Vehicle vehicle7;
		Vehicle vehicle8;
		Vehicle vehicle9;
		Vehicle vehicle10;
		Vehicle vehicle11;
		vehicle1=controller.createVehicle(1213, VehicleType.CAR);
		vehicle2=controller.createVehicle(1212, VehicleType.MOTORCYCLE);
		vehicle3=controller.createVehicle(1215, VehicleType.MOTORCYCLE);
		vehicle4=controller.createVehicle(1216, VehicleType.CAR);
		vehicle5=controller.createVehicle(1217, VehicleType.CAR);
		vehicle6=controller.createVehicle(1218, VehicleType.MOTORCYCLE);
		vehicle7=controller.createVehicle(1219, VehicleType.MOTORCYCLE);
		vehicle8=controller.createVehicle(1220, VehicleType.CAR);
		vehicle9=controller.createVehicle(1221, VehicleType.MOTORCYCLE);
		vehicle10=controller.createVehicle(1222, VehicleType.CAR);
		vehicle11=controller.createVehicle(1223, VehicleType.CAR);
		Driver driver1;
		Driver driver2;
		Driver driver3;
		Driver driver4;
		Driver driver5;
		Driver driver6;
		Driver driver7;
		driver1=controller.createDriver("A");
		driver2=controller.createDriver("B");
		driver3=controller.createDriver("C");
		driver4=controller.createDriver("D");
		driver5=controller.createDriver("E");
		driver6=controller.createDriver("F");
		driver7=controller.createDriver("G");
		Staff staff1;
		Staff staff2;
		staff1=controller.createStaff("staffA");
		staff2=controller.createStaff("staffB");
		controller.addCarInDriver(driver1, vehicle1);
		controller.addCarInDriver(driver1, vehicle2);
		controller.addCarInDriver(driver2, vehicle3);
		controller.addCarInDriver(driver2, vehicle4);
		controller.addCarInDriver(driver3, vehicle5);
		controller.addCarInDriver(driver4, vehicle6);
		controller.addCarInDriver(driver4, vehicle7);
		controller.addCarInDriver(driver5, vehicle8);
		controller.addCarInDriver(driver5, vehicle9);
		controller.addCarInDriver(driver6, vehicle10);
		controller.addCarInDriver(driver7, vehicle11);
		Reservation R1=controller.createReservation(driver1, vehicle1.getPlateNumber(), staff1);
		Reservation R2=controller.createReservation(driver1, vehicle2.getPlateNumber(), staff1);
		Reservation R3=controller.createReservation(driver2, vehicle3.getPlateNumber(), staff1);
		Reservation R4=controller.createReservation(driver2, vehicle4.getPlateNumber(), staff1);
		Reservation R5=controller.createReservation(driver3, vehicle5.getPlateNumber(), staff2);
		Reservation R6=controller.createReservation(driver4, vehicle6.getPlateNumber(), staff1);
		Reservation R7=controller.createReservation(driver4, vehicle7.getPlateNumber(), staff2);
		Reservation R8=controller.createReservation(driver5, vehicle8.getPlateNumber(), staff2);
		Reservation R9=controller.createReservation(driver5, vehicle9.getPlateNumber(), staff2);
		Reservation R10=controller.createReservation(driver6, vehicle10.getPlateNumber(), staff2);
		Reservation R11=controller.createReservation(driver7, vehicle11.getPlateNumber(), staff2);
		controller.staffActiveReservationsDetails(staff1.getName());
		controller.closeTheReservation(R1);
		controller.closeTheReservation(R2);
		Vehicle vehicle12;
		Vehicle vehicle13;
		vehicle12=controller.createVehicle(1212, VehicleType.CAR);
		vehicle13=controller.createVehicle(1212, VehicleType.MOTORCYCLE);


	
		//controller.garageAvailabillity();
		

	

		
		
	
		
	}

}
