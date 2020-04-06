package relationships.association;

import java.util.ArrayList;

public class Student {
	private String name;
	private Professor advisor;
	private ArrayList<Transcript> transcripts;
	public Student(String name) {
		this.name = name;
		transcripts = new ArrayList<>();
	}
	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}
	public void advise(String msg) {
		System.out.println(msg);
	}
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);
	}
	public ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		for(Transcript transcript: transcripts) {
			courses.add(transcript.getCourse());
		}
		return courses;
	}
}
