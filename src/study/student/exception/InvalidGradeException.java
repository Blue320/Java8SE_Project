package study.student.exception;

public class InvalidGradeException extends Exception {
	private int invalidGrade;
	
	public InvalidGradeException(String message, int grade) {
		super(message);
		invalidGrade = grade;
	}
	public int getInvalidGrade() {
		return invalidGrade;
	}
}
