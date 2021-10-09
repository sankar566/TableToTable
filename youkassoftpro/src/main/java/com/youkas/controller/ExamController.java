package com.youkas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youkas.dto.StudentDataDto;
import com.youkas.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
   @PostMapping("/userexam")
   public String createUserExam(@RequestBody StudentDataDto student) {
		
	return examService.addUserExaam(student);
	}
   
   @GetMapping("/studentExamDetails")
   public StudentDataDto getStudentExamDetails(@RequestParam Integer studentId) {
	   
	   return examService.getStudentExamDetails(studentId);
	   
   }

}
