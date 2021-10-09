package com.youkas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youkas.dto.AddressDto;
import com.youkas.dto.StudentDataDto;
import com.youkas.service.StudentService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/test")
	public Map<String,String> testApp(@RequestParam( required = false) String name, @RequestParam("ad") String address) {
		
		System.out.println("Yes working Good............"+name +":"+address);
		Map<String,String> rsMap = new HashMap<>();
		rsMap.put("name", name);
		rsMap.put("address", address);
		return rsMap;
	}
	
	//http://localhost:8080/home/test
	//http://localhost:9080/book/test
	
	@PostMapping("/addstudent")
	public String addStudentData(@RequestBody StudentDataDto studentdataDto ) {
		
		
		return studentService.saveStudentData(studentdataDto);
	}
	
	@PostMapping("/addaddress")
	public String addAddress(@RequestBody AddressDto addressDto ) {
		
		
		return studentService.saveAddress(addressDto);
	}
}
