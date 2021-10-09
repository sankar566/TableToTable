package com.youkas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="examdetails")
public class ExamDetails implements Serializable{
	
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="exam_id")
	private Integer examId;
	
	@Column(name="exam_name")
	private String examName;
	
	@Column(name="year")
	private String year;
	
	@Column(name="exam_type")
	private String examType;
	
	@ManyToOne
	private StudentData student;
	
	

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getExamType() {
		return examType;
	}

	public void setExamType(String examType) {
		this.examType = examType;
	}
	
	public StudentData getStudent() {
		return student;
	}

	public void setStudent(StudentData student) {
		this.student = student;
	}

}
