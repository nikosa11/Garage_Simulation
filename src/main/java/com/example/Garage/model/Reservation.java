package com.example.Garage.model;
import java.time.Duration;
import java.time.LocalDateTime;
public class Reservation {
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	private String driverName;
	private Integer driverPlateNumber;
	private boolean discount=false;
	private VehicleType vehicleType;
	private String staffName;
	
	
	
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String custName) {
		this.driverName = custName;
	}
	public Integer getDriverPlateNumber() {
		return driverPlateNumber;
	}
	public void setDriverPlateNumber(Integer custPlateNumber) {
		this.driverPlateNumber = custPlateNumber;
	}
	public Reservation(Driver driver,int plateNumber,Staff staff,VehicleType vehicleType) {
		startTime=LocalDateTime.now();
		driverName=driver.getName();
		driverPlateNumber=plateNumber;
		this.vehicleType=vehicleType;
		this.staffName=staff.getName();
		
		
	}
	
	public void setDiscount() {
		discount=true;
	}
	public boolean getDiscount() {
		return discount;
	}
	public long calculateDuration(){
		endTime=LocalDateTime.now();
		long timeToMinute=Duration.between(startTime, endTime).toMinutes();
		return timeToMinute;

		}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverPlateNumber == null) ? 0 : driverPlateNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (driverPlateNumber == null) {
			if (other.driverPlateNumber != null)
				return false;
		} else if (!driverPlateNumber.equals(other.driverPlateNumber))
			return false;
		return true;
	}
	public VehicleType calculateTheCost() {
		return vehicleType;
	}
	@Override
	public String toString() {
		return "Reservation [Start Time=" + startTime + ", End Time=" + endTime +  ", Driver Name=" + driverName + ", Driver Plate Number=" + driverPlateNumber + ", Vehicle Type="
				+ vehicleType + ", Staff Name=" + staffName + "]";
	}
	
	

}
