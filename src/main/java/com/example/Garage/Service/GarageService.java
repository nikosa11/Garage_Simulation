package com.example.Garage.Service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.Garage.model.Reservation;
import com.example.Garage.model.VehicleType;


public class GarageService {
	static Log log = LogFactory.getLog(GarageService.class);

	Set<Reservation> activeReservations=new HashSet<Reservation>();
	Set<Reservation> completedReservations=new HashSet<Reservation>();
	final int maximumSize=10;
	double totalCost=0;
	final int costPerHour=10;
	
	public String newReservation(Reservation newReservation)  {
	


		if(activeReservations.isEmpty()) {
			log.info("newReservation.toString()");
			activeReservations.add(newReservation);
			return newReservation.toString();
			}
		if(giveMeTheAvailability()>0) {
		for(Reservation reservation :activeReservations) {
			if(newReservation.getDriverPlateNumber()==reservation.getDriverPlateNumber()) {
				log.info("The Vehicle is already in the garage");
				return "Error";
			}
			if(reservation.getDriverName().equals(newReservation.getDriverName())) {
			
				reservation.setDiscount();
				newReservation.setDiscount();
				
			}
				}
		activeReservations.add(newReservation);
		log.info(newReservation.toString());
		return newReservation.toString();
		
	}
		log.info("Garage is full");
		return "Garage is full";

		}

	
	public double reservationCost(Reservation reservation) {
		double cost=0;
		double time=0;
		double calculateCostPerHour=costPerHour;
		time=reservation.calculateDuration();
		//time=60; //for test
		if(reservation.calculateTheCost()==VehicleType.MOTORCYCLE) {
			calculateCostPerHour=costPerHour-5;
		}
		if(reservation.getDiscount()&&time>=30) {
			time=time-30;
			time=time/60;
			cost=time*calculateCostPerHour;
			cost=cost-0.3*cost;
			totalCost=totalCost+cost;
			log.info(cost);
			return cost;
		}
		cost=(time/60)*calculateCostPerHour;
		totalCost=totalCost+cost;
		log.info("Cost of Reservation");
		log.info(cost);
		return cost;
		
	}
	
	
	public Double getTotalCost() {
		return totalCost;
	}
	public String newAvailableSeat(Reservation reservation) {
		for(Reservation activeReservation:activeReservations) {
			if((reservation.getDriverPlateNumber()==activeReservation.getDriverPlateNumber())&&(reservation.getDriverName().equals(activeReservation.getDriverName()))) {
				activeReservations.remove(activeReservation);
				log.info("A new spot is free ");
				reservationCost(activeReservation);
				completedReservations.add(reservation);
				return reservation.toString();
			}
		}
		return "I cant find reservation with the require PlateNumber and Name ";
		
	}
	
	
	public int giveMeTheAvailability() {
		log.info(" The availables spots are ");
		log.info(maximumSize-activeReservations.size());
		return maximumSize-activeReservations.size();
		
	}
	
	public void returnTheActiveReservations() {
		log.info(" The The Actives Reservations are ");

		log.info(activeReservations.size());
		log.info(activeReservations);
	}
	
	public void giveMeStaffDetails(String staffName) {
		for(Reservation reservation:activeReservations) {
			if(staffName.equals(reservation.getStaffName())) {
				log.info(reservation.toString());
			}
		}
	}


}
