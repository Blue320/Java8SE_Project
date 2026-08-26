package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student student = new Student("20196627", "김민수", "컴퓨터공학", 3);
            System.out.println(student);

            student.setGrade(5);

        } catch (InvalidGradeException exp) {
            // exp.getCurrentGrade()를 통해 넘겨진 숫자를 자동으로 출력
            System.out.println(exp.getCurrentGrade() + "학년으로 변경");
            System.out.println(exp.getMessage());
        }
    }
}