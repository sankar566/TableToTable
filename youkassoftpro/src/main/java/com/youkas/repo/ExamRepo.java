package com.youkas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youkas.model.ExamDetails;

@Repository
public interface ExamRepo extends JpaRepository<ExamDetails, Integer>{

}
