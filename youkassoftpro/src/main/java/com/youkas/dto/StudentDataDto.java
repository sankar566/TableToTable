package com.youkas.dto;

import java.time.LocalDate;
import java.util.List;

import com.youkas.model.ExamDetails;

public class StudentDataDto {
	
	private Integer studentId;
	
	private String studentName;

	private String dep;
	
	private LocalDate dateOfBirth;
	
	private AddressDto addressDto;
	
	private List<UserExamDto> examDetailsDto;

	
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

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	
	public List<UserExamDto> getExamDetailsDto() {
		return examDetailsDto;
	}

	public void setExamDetailsDto(List<UserExamDto> examDetailsDto) {
		this.examDetailsDto = examDetailsDto;
	}

	

}
