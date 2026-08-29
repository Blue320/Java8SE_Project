package study.student.entity;

import study.student.exception.InvalidGradeException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student (String studentId, String name, String major, int grade) throws InvalidGradeException {
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		setGrade(grade);
		System.out.println();
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) throws InvalidGradeException {
		if (grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.", grade);
		}
		else {
			this.grade = grade;
		}
	}
	@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "학년";
	}
	
}
