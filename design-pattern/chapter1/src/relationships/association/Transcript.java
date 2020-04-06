package relationships.association;

public class Transcript {
	private Student student;
	private Course course;
	private String date;
	private String grade;
	public Transcript(Student student, Course course) {
		this.student = student;
		this.course = course;
		student.addTranscript(this);
		course.addTranscript(this);
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
