package com.optrident;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subjects")
public class Subjects {
	
	@Id
	@Column(name = "student_id")
	private String student_id;
	private Long roll_no;
	private boolean hindi;
	private boolean english;
	private boolean math;
	private boolean science;
	private boolean computer;
	
	@OneToOne(mappedBy = "subject")
	@JsonIgnore
	private Student students;
	
	public Subjects() {
		super();
	}

	public Subjects(String student_id, Long roll_no, boolean hindi, boolean english, boolean math, boolean science,
			boolean computer, Student students) {
		super();
		this.student_id = student_id;
		this.roll_no = roll_no;
		this.hindi = hindi;
		this.english = english;
		this.math = math;
		this.science = science;
		this.computer = computer;
		this.students = students;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public Long getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(Long roll_no) {
		this.roll_no = roll_no;
	}

	public boolean isHindi() {
		return hindi;
	}

	public void setHindi(boolean hindi) {
		this.hindi = hindi;
	}

	public boolean isEnglish() {
		return english;
	}

	public void setEnglish(boolean english) {
		this.english = english;
	}

	public boolean isMath() {
		return math;
	}

	public void setMath(boolean math) {
		this.math = math;
	}

	public boolean isScience() {
		return science;
	}

	public void setScience(boolean science) {
		this.science = science;
	}

	public boolean isComputer() {
		return computer;
	}

	public void setComputer(boolean computer) {
		this.computer = computer;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Subjects [student_id=" + student_id + ", roll_no=" + roll_no + ", hindi=" + hindi + ", english="
				+ english + ", math=" + math + ", science=" + science + ", computer=" + computer + ", students="
				+ students + "]";
	}

	
}
