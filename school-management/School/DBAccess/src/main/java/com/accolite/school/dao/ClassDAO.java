package com.accolite.school.dao;

import java.util.List;

import com.accolite.school.model.Classes;

public interface ClassDAO {

	public List<Classes> getAllClasses();

	public Classes getClassById(int classId);

	public void addClass(Classes classs);

	public void editClass(Classes updatedClass);

	public void deleteClass(int classId);
	
	public List getAllClassWithFeeLiabitiesAndSchedule();
}
