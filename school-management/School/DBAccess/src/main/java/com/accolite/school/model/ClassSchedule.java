package com.accolite.school.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLASS_SCHEDULE")
public class ClassSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "START_TIME")
	@Temporal(TemporalType.TIME)
	private Date startTime;

	@Column(name = "END_TIME")
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	@Column(name = "DURATION")
	private int duration;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLASS_ID")
	private Classes classs;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Classes getClasss() {
		return classs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClasss(Classes classs) {
		this.classs = classs;
	}

}
