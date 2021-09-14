package org.school.schedule;

import java.util.ArrayList;
import java.util.Arrays;

import org.school.schedule.domain.Course;
import org.school.schedule.domain.Department;
import org.school.schedule.domain.Lecturer;
import org.school.schedule.domain.Room;
import org.school.schedule.domain.Time;

public class Data {
	private ArrayList<Lecturer> lecturers;
	private ArrayList<Course> courses;
	private ArrayList<Room> rooms;
	private ArrayList<Department> depts;
	private ArrayList<Time> times;
	private int numberOfClasses = 0;
	
	
	public Data() {
		initialize();
	}


	private Data initialize() {
		Room room = new Room("D1", 25);
		Room room2 = new Room("D2", 15);
		Room room3 = new Room("D3", 24);
		rooms = new ArrayList<Room>(Arrays.asList(room, room2, room3));
		Time time1 = new Time("T1", "MWF 09:00 - 10:00");
		Time time2 = new Time("T2", "MWF 09:00 - 11:00");
		Time time3 = new Time("T3", "TTH 09:00 - 10:00");
		Time time4 = new Time("T4", "TTH 09:00 - 12:00");
		times = new ArrayList<Time>(Arrays.asList(time1, time2, time3, time4));
		Lecturer lecturer1 = new Lecturer("L1", "Mr John");
		Lecturer lecturer2 = new Lecturer("L2", "Dr Peter");
		Lecturer lecturer3 = new Lecturer("L3", "Mr Chikari");
		Lecturer lecturer4 = new Lecturer("L4", "Dr Rashford");
		lecturers = new ArrayList<Lecturer>(Arrays.asList(lecturer1, lecturer2, lecturer3, lecturer4));
		Course course1 = new Course("C1", "126K", new ArrayList<Lecturer>(Arrays.asList(lecturer1, lecturer2)), 21);
		Course course2 = new Course("C2", "363K", new ArrayList<Lecturer>(Arrays.asList(lecturer4, lecturer2)), 25);
		Course course3 = new Course("C3", "311K", new ArrayList<Lecturer>(Arrays.asList(lecturer3, lecturer4)), 20);
		Course course4 = new Course("C4", "453K", new ArrayList<Lecturer>(Arrays.asList(lecturer3, lecturer2)), 23);
		Course course5 = new Course("C5", "122K", new ArrayList<Lecturer>(Arrays.asList(lecturer1, lecturer4)), 29);
		Course course6 = new Course("C6", "170K", new ArrayList<Lecturer>(Arrays.asList(lecturer4, lecturer2)), 26);
		Course course7 = new Course("C7", "124K", new ArrayList<Lecturer>(Arrays.asList(lecturer1, lecturer4)), 22);

		courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));
		Department dept1 = new Department("Math",  new ArrayList<Course>(Arrays.asList(course5, course6)));
		Department dept2 = new Department("Geo",  new ArrayList<Course>(Arrays.asList(course1, course3)));
		Department dept3 = new Department("His",  new ArrayList<Course>(Arrays.asList(course2, course4)));
		depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
		depts.forEach(x -> numberOfClasses += x.getCourses().size());
		return this;
	}
	
	
	public ArrayList<Lecturer> getLecturers() {
		return lecturers;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public ArrayList<Department> getDepts() {
		return depts;
	}
	public ArrayList<Time> getTimes() {
		return times;
	}
	public int getGetNumberOfClasses() {
		return this.numberOfClasses;
	}
	
}
