package com.accolite.school.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FEE_TEMPLATE")
public class FeeTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "FACILITY")
	private String facility;

	@Column(name = "FEE_REPEAT")
	private String feeRepeat;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "DEADLINE")
	private int deadline;

	@Column(name = "REMAINDER")
	private int remainder;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLASS_ID")
	private Classes clss;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getFeeRepeat() {
		return feeRepeat;
	}

	public void setFeeRepeat(String feeRepeat) {
		this.feeRepeat = feeRepeat;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public Classes getClss() {
		return clss;
	}

	public void setClss(Classes clss) {
		this.clss = clss;
	}

}
