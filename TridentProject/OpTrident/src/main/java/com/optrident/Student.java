package com.optrident;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	private String student_id;
	
	private Long roll_no;
	
	private String name;
	
	private Long student_class;
	
	@OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "subjects_student_id", referencedColumnName = "student_id")
	private Subjects subject;
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String student_id, Long roll_no, String name, Long student_class, Subjects subject) {
		super();
		this.student_id = student_id;
		this.roll_no = roll_no;
		this.name = name;
		this.student_class = student_class;
		this.subject = subject;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getStudent_class() {
		return student_class;
	}
	
	public void setStudent_class(Long student_class) {
		this.student_class = student_class;
	}
	
	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", roll_no=" + roll_no + ", name=" + name + ", student_class="
				+ student_class + ", subject=" + subject + "]";
	}

	
	
}
