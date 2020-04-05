package relationships.association;

public class Main {
	public static void main(String[] args) {
		Professor professor = new Professor();
		Student student = new Student("kim");
		professor.setStudent(student);
		professor.advise();
		
	}
}
