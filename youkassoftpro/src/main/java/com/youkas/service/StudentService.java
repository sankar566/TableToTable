package com.youkas.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youkas.dto.AddressDto;
import com.youkas.dto.StudentDataDto;
import com.youkas.model.Address;
import com.youkas.model.StudentData;
import com.youkas.repo.AddressRepo;
import com.youkas.repo.StudentDataRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentDataRepo studentDataRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	public String saveStudentData(StudentDataDto studentdataDto) {
		// TODO Auto-generated method stub
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
		return "Successfully Student Data Registred........... ";
	}

	public String saveAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		StudentData studentData = studentDataRepo.findByStudentId(addressDto.getStudentId());
		if(studentData != null) {
        Address ad = new Address();
		
		ad.setCity(addressDto.getCity());
		ad.setCountry(addressDto.getCountry());
		ad.setState(addressDto.getState());
		ad.setStudentData(studentData);
		addressRepo.save(ad);
		return "Successfully Address Data Registred........... ";
		}
		else {
			return "Invalid userId........... ";
		}
		
		
	}

}
