package com.youkas.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youkas.dto.AddressDto;
import com.youkas.dto.StudentDataDto;
import com.youkas.dto.UserExamDto;
import com.youkas.model.Address;
import com.youkas.model.ExamDetails;
import com.youkas.model.StudentData;
import com.youkas.repo.AddressRepo;
import com.youkas.repo.ExamRepo;
import com.youkas.repo.StudentDataRepo;

@Service
public class ExamService {
	
	@Autowired
	private StudentDataRepo studentDataRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ExamRepo examRepo;

	
	public String addUserExaam(StudentDataDto studentdataDto) {
		
		StudentData student = new StudentData();
		student.setStudentName(studentdataDto.getStudentName());
		student.setDep(studentdataDto.getDep());
		student.setDateOfBirth(LocalDate.now());
		student = studentDataRepo.save(student);
		
		Address ad = new Address();
		
		ad.setCity(studentdataDto.getAddressDto().getCity());
		ad.setCountry(studentdataDto.getAddressDto().getCountry());
		ad.setState(studentdataDto.getAddressDto().getState());
		ad.setStudentData(student);
		addressRepo.save(ad);
		
		for(UserExamDto examDto : studentdataDto.getExamDetailsDto()) {
			
			ExamDetails exam = new ExamDetails();
			exam.setStudent(student);
			exam.setExamName(examDto.getExamName());
			exam.setExamType(examDto.getExamType());
			exam.setYear(examDto.getYear());
			examRepo.save(exam);
			
		}
		
		return "Successfully ExamDetails Added......";
	}


	public StudentDataDto getStudentExamDetails(Integer studentId) {
		// TODO Auto-generated method stub
		StudentDataDto studentDataDto = new StudentDataDto();
		StudentData student =	studentDataRepo.findByStudentId(studentId);
		if(student != null) {
			studentDataDto.setStudentId(student.getStudentId());
			studentDataDto.setStudentName(student.getStudentName());
			studentDataDto.setDep(student.getDep());
			studentDataDto.setDateOfBirth(student.getDateOfBirth());
			
			AddressDto addressDto = new AddressDto();
			addressDto.setAddressId(student.getAddress().getAddressId());
			addressDto.setCity(student.getAddress().getCity());
			addressDto.setState(student.getAddress().getState());
			addressDto.setCountry(student.getAddress().getCountry());
			
			studentDataDto.setAddressDto(addressDto);
			
			List<UserExamDto> userExamDtoList = new ArrayList<>();
			
			for(ExamDetails exam : student.getExamDetails()) {
				
				UserExamDto userExamDto = new UserExamDto();
				userExamDto.setExamId(exam.getExamId());
				userExamDto.setExamName(exam.getExamName());
				userExamDto.setExamType(exam.getExamType());
				userExamDto.setYear(exam.getYear());
				userExamDtoList.add(userExamDto);
			}
			studentDataDto.setExamDetailsDto(userExamDtoList);
			
		}
		return studentDataDto;
	}
	
	
	

}
