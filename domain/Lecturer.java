package org.school.schedule.domain;

public class Lecturer {
	private String id;
	private String name;
	public Lecturer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
	
}
