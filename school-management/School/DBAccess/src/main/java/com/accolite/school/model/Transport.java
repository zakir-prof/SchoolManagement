package com.accolite.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSPORT")
public class Transport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME", length = 100)
	private String name;

	@Column(name = "DRIVER_NAME", length = 100)
	private String driverName;

	@Column(name = "MOBILE", length = 20)
	private String mobileNumber;

	@Column(name = "EMAIL")
	private String emailId;

	@Column(name = "CAPACITY")
	private int capacity;

	@Column(name = "AVAILABLE")
	private int available;

	@Column(name = "OCCUPIED")
	private int occupied;

	@Column(name = "DRIVER_ADDRESS", length = 255)
	private String driverAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

}
