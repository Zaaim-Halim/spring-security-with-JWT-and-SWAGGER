package com.example.CollegeManagementSystem.sevice;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeManagementSystem.entities.College;
import com.example.CollegeManagementSystem.reposittories.CollegeRepository;


@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository; 
	public List<College> findAll() {
		return (List<College>) collegeRepository.findAll();
	}

	public Optional<College> findById(Integer id) {
		return collegeRepository.findById(id);
	}
	public void AddCollege(College college) {
		collegeRepository.save(college);
	}

	public void UpdateCollege(College college) {
		
		collegeRepository.save(college);
		
	}

	public void deleteCollege(Integer id) {
		collegeRepository.deleteById(id);
		
	}

	

	
}
