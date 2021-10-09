package com.youkas.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentData {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="dep")
	private String dep;
	
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@OneToOne(mappedBy = "studentData")
	private Address address;
	
	@OneToMany(mappedBy = "student")
	List<ExamDetails> examDetails;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ExamDetails> getExamDetails() {
		return examDetails;
	}

	public void setExamDetails(List<ExamDetails> examDetails) {
		this.examDetails = examDetails;
	}
	
	
	

}
