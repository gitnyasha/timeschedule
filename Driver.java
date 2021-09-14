package org.school.schedule;

import java.util.ArrayList;
import org.school.schedule.domain.Class;

public class Driver {

	public static final int POPULATION_SIZE = 9;
	public static final double MUTATION_RATE = 0; 
	public static final double CROSSOVER_RATE = 0.9;
	public static final int TOURNAMENT_SELECTION_SIZE = 3;
	public static final int NUMB_OF_ELITE_SCHEDULES = 1;
	private int scheduleNumb = 1;
	private int classNumb = 0;
	private Data data;
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.data = new Data();
		int generationNumber = 0;
		driver.printAvailableData();
		System.out.println("> Generate # "+generationNumber);
		System.out.print("  Schedule # |                                         ");
		System.out.print("  Classes [department, class, lecturer,  time, block]         ");
		System.out.println("                                           | Fitness | Conflicts");
		System.out.print("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
		Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
		population.getSchedules().forEach(schedule -> System.out.println("        "+driver.scheduleNumb++ +
				"       |  "+ schedule + "  |  " + String.format("%.5f", schedule.getFitness()) +
				
				"  |  "+schedule.getNumberOfConflicts()));
		driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
		driver.classNumb = 1;
		while (population.getSchedules().get(0).getFitness() != 1.0) {
			System.out.println("> Generate # "+generationNumber);
			System.out.print("  Schedule # |                                         ");
			System.out.print("  Classes [department, class, lecturer,  time, block]         ");
			System.out.println("                                           | Fitness | Conflicts");
			System.out.print("--------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------");
			population = geneticAlgorithm.evolve(population).sortByFitness();
			driver.scheduleNumb = 0;
			population.getSchedules().forEach(schedule -> System.out.println("          "+driver.scheduleNumb++
					+ "       |  "+ schedule + "   |   " +
					String.format("%.5f", schedule.getFitness()) + "  |  "+schedule.getNumberOfConflicts()));
			driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
			driver.classNumb = 1;
		}
	}
	
	private void printScheduleAsTable(Schedule schedule,int generation) {
		ArrayList<Class> classes =  schedule.getClasses();
		System.out.print("\n                         ");
		System.out.println("  Class # | department | course (Students) | block (Capacity) | Lecturer (id) | Time");
		System.out.print("                         ");
		System.out.print("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
		classes.forEach(x -> {
			int majorIndex = data.getDepts().indexOf(x.getDept());
			int coursesIndex = data.getCourses().indexOf(x.getCourse());
			int blocksIndex = data.getRooms().indexOf(x.getRoom());
			int lecturersIndex = data.getLecturers().indexOf(x.getLecturer());
			int timesIndex = data.getTimes().indexOf(x.getTime());
			System.out.print("                         ");
			System.out.print(String.format("   %1$02d   ", classNumb) + "  |  ");
			System.out.print(String.format("   %1$4s   ", data.getDepts().get(majorIndex).getName()) + "  |  ");
			System.out.print(String.format("   %1$21s   ", data.getCourses().get(coursesIndex).getName() +
					" ("+data.getCourses().get(coursesIndex).getNumber() +", "+
					x.getCourse().getMaxNumberOfStudents())+")          |");
			System.out.print(String.format("   %1$10s   ", data.getRooms().get(blocksIndex).getNumber() +
					" ("+ x.getRoom().getSeatingCapacity()) + ")    |  ");
			System.out.print(String.format("   %1$15s   ", data.getLecturers().get(lecturersIndex).getName() +
					" ("+ data.getLecturers().get(lecturersIndex).getId()+")") + ")    |  ");
			System.out.println(data.getTimes().get(timesIndex).getTime() +
					" ("+ data.getTimes().get(timesIndex).getId()+")");
			classNumb++;
		});
		if (schedule.getFitness() == 1) {
			System.out.println("> Solution Found in "+ (generation + 1) +" generations");
		}
		System.out.print("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
	}
	
	private void printAvailableData() {
		System.out.println("Available Departments ==>");
		data.getDepts().forEach(x -> System.out.println("name: "+x.getName()+", courses: "+x.getCourses()));
		System.out.println("\nAvailable Courses ==>");
		data.getCourses().forEach(x -> System.out.println("course: "+x.getNumber()+", name: "+x.getName()+", max # of students: "
				+ x.getMaxNumberOfStudents()+", lecturers: "+ x.getLecturers()));
		System.out.println("Available Blocks ==>");
		data.getRooms().forEach(x -> System.out.println("block #: "+x.getNumber()+", max chairs: "+ x.getSeatingCapacity()));
		System.out.println("Available Lecturers ==>");
		data.getLecturers().forEach(x -> System.out.println("id #: "+x.getId()+", name: "+ x.getName()));
		System.out.println("Available Hours ==>");
		data.getTimes().forEach(x -> System.out.println("id #: "+x.getId()+", Time: "+ x.getTime()));
		System.out.print("--------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------");
	}

}
