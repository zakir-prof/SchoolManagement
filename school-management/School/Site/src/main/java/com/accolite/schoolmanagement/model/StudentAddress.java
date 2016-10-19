package com.accolite.schoolmanagement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "STUDENT_ADDRESS")
public class StudentAddress {

	@Id
	@GeneratedValue
	private int address_id;
	
	@Column(name = "student_address", nullable=false)
	private String address;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	public Student getStudents() {
		return student;
	}

	public void setStudents(Student student) {
		this.student = student;
	}*/

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}