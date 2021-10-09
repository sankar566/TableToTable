package com.youkas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youkas.model.StudentData;

@Repository
public interface StudentDataRepo extends JpaRepository<StudentData, Integer> {
	
	public StudentData findByStudentId(Integer studentId);
	

}
