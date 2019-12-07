package org.object.override;

public class StudentClass {
	String name, number;
	int birthYear;
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthYear;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentClass other = (StudentClass) obj;
		if (birthYear != other.birthYear)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "StudentClass [name=" + name + ", number=" + number + ", birthYear=" + birthYear + "]";
	}

	public static void main(String[] args) {
		StudentClass s1 = new StudentClass();
		s1.name = "aaa";
		s1.number = "1111";
		s1.birthYear = 1111;

		
		StudentClass s2 = new StudentClass();
		s2.name = "aaa";
		s2.number = "1111";
		s2.birthYear = 1111;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		if(s1 == s2) System.out.println("==");
		if(s1.equals(s2)) System.out.println("equals");
		System.out.println(s1);
	}
}
