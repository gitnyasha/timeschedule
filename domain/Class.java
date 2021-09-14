package org.school.schedule.domain;

public class Class {
	private int id;
	private Department dept;
	private Course course;
	private Lecturer lecturer;
	private Time times;
	private Room room;
	public Class(int id, Department dept, Course course) {
		super();
		this.id = id;
		this.dept = dept;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public Department getDept() {
		return dept;
	}
	public Course getCourse() {
		return course;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public Time getTime() {
		return times;
	}
	public Room getRoom() {
		return room;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	public void setTime(Time time) {
		this.times = time;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String toString() {
		return "["+dept.getName() + ", " + course.getNumber() + ", " + lecturer.getId() + ", " + times.getId() + ", "
				+ room.getNumber() + "]";
	}
	
	
}
