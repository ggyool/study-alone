package relationships.association;

import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList<Transcript> transcripts;
	public Course(String name) {
		this.name = name;
		transcripts = new ArrayList<>();
	}
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);	
	}
	public ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<>();
		for(Transcript transcript : transcripts) {
			students.add(transcript.getStudent());
		}
		return students;
	}
}
