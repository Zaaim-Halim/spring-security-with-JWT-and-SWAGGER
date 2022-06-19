package com.example.CollegeManagementSystem.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeManagementSystem.entities.Faculty;
import com.example.CollegeManagementSystem.reposittories.FacultyRepository;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	public List<Faculty> findAll() {
		return (List<Faculty>) facultyRepository.findAll();
	}
	public Optional<Faculty> findById(Integer id) {
		return facultyRepository.findById(id);
	}
	public void addFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
		
	}
	public void updateFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
		
	}
	public void deleteFaculty(Integer id) {
		facultyRepository.deleteById(id);
		
	}

}
