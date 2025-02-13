package p0212;

import java.util.ArrayList;

public class ListTest3 {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("이용규");
		s1.setGrade(1);
		s1.setSchoolName("이젠");
		
		Student s2 = new Student();
		s2.setName("김용규");
		s2.setGrade(3);
		s2.setSchoolName("삼젠");
		
		
		Student s3 = new Student();
		s3.setName("박용규");
		s3.setGrade(6);
		s3.setSchoolName("육젠");
		
		Student s4 = new Student();
		s4.setName("최용규");
		s4.setGrade(4);
		s4.setSchoolName("이젠");
		
		Student s5 = new Student();
		s5.setName("용용규");
		s5.setGrade(8);
		s5.setSchoolName("팔젠");
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		for(Student s:students) {
			if(s.getName().indexOf("최")==0 || "이젠".equals(s.getName())){ //  .substring(0,1).equals("최")  보다 좋은게 .startsWith("최"))
			System.out.println(s);
			}
		}
		
	}
}
