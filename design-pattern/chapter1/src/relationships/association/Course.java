package relationships.association;

import java.util.ArrayList;

public class Course {
	String name;
	private ArrayList<Student> students;
	public Course(String name) {
		this.name = name;
		students = new ArrayList<>();
	}
	public void addStudent(Student student) {
		students.add(student);
	}
}
