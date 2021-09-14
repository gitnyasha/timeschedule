package org.school.schedule.domain;

import java.util.ArrayList;

public class Course {
	private String number = null;
	private String name = null;
	private int maxNumberOfStudents;
	private ArrayList<Lecturer> lecturers;
	public Course(String number, String name, ArrayList<Lecturer> lecturers, int maxNumberOfStudents) {
		super();
		this.name = name;
		this.number = number;
		this.lecturers = lecturers;
		this.maxNumberOfStudents = maxNumberOfStudents;
	}
	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getMaxNumberOfStudents() {
		return maxNumberOfStudents;
	}

	public ArrayList<Lecturer> getLecturers() {
		return lecturers;
	}
	public String toString() {
		return name;
	}
	
}
