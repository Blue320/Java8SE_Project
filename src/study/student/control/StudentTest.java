package study.student.control;

import study.student.control.*;
import study.student.entity.Student;
import study.student.exception.InvalidGradeException;;

public class StudentTest {
	public static void main(String[] args) {
		
		try {
			Student info = new Student("20196627","김민수","컴퓨터공학",3);
			
			
		}
		catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
}
