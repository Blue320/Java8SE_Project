package study.student.exception;

public class InvalidGradeException extends Exception {
	public InvalidGradeException(String message) {
		super(message);
		System.out.println(message);
	}
}
