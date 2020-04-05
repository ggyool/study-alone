package relationships.association;

import java.util.ArrayList;

public class Student {
	private String name;
	private Professor advisor;
	private ArrayList<Course> courses;
	public Student(String name) {
		this.name = name;
		courses = new ArrayList<>();
	}
	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}
	public void advise(String msg) {
		System.out.println(msg);
	}
	public void registerCourse(Course course) {
		courses.add(course);
		course.addStudent(this);
	}
	public boolean dropCourse(Course course) {
		return courses.remove(course);
	}
	
}
