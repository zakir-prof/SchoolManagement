package com.accolite.school.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLASS_ID")
	private Classes classs;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEACHER_ID")
	private Staff staff;

	public Staff getStaffs() {
		return staff;
	}

	public void setStaffs(Staff staff) {
		this.staff = staff;
	}

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

	public Classes getClasss() {
		return classs;
	}

	public void setClasss(Classes classs) {
		this.classs = classs;
	}

}
