package org.school.schedule;

import java.util.ArrayList;
import org.school.schedule.domain.Class;

import org.school.schedule.domain.Department;

public class Schedule {
	private ArrayList<Class> classes;
	private int classNumber = 0;
	private Data data;
	private int numberOfConflicts = 0;
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	public Data getData() {
		return data;
	}
	public Schedule(Data data) {
		this.classes = new ArrayList<Class>(data.getGetNumberOfClasses());
		this.data = data;
	}
	
	public Schedule initialize() {
		new ArrayList<Department>(data.getDepts()).forEach(dept -> {
			dept.getCourses().forEach(course -> {
				Class newClass =  new Class(classNumber++, dept, course);
				newClass.setTime(data.getTimes().get((int) (data.getTimes().size() *  Math.random())));
				newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
				newClass.setLecturer(data.getLecturers().get((int) (course.getLecturers().size() * Math.random())));
				classes.add(newClass);
			});
		});
		return this;
	}
	public int getNumberOfConflicts() {
		return numberOfConflicts;
	}
	
	public ArrayList<Class> getClasses() {
		isFitnessChanged =  true;
		return classes;
	}
	
	public String toString() {
		String returnValue = new String();
		for (int x = 0; x < classes.size()-1; x++) returnValue += classes.get(x) + ", ";
		returnValue += classes.get(classes.size()-1);
		return returnValue;
	}
	
	public double getFitness() {
		if (isFitnessChanged == true) {
			fitness = calcFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}
	
	private double calcFitness() {
		numberOfConflicts = 0;
		classes.forEach(x -> {
			if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents()) numberOfConflicts++;
			classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
				if (x.getTime() == y.getTime() && x.getId() != y.getId()) {
					if (x.getRoom() == y.getRoom()) numberOfConflicts++;
					if (x.getLecturer() == y.getLecturer()) numberOfConflicts++;
				}
			});
		});
		return 1/(double)(numberOfConflicts + 1);
	}
}
