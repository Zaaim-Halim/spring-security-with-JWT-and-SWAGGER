package com.example.CollegeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CollegeManagementSystem.entities.Faculty;
import com.example.CollegeManagementSystem.sevice.FacultyService;

@RestController

@RequestMapping("/api")

public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/faculties")//List of faculties
	public List<Faculty> getAllfaculties() {
	    return facultyService.findAll();
	}

	@GetMapping("/faculties/{id}")//faculties details by id
	public Optional<Faculty> getfacultiesById(@PathVariable Integer id) {
	    return facultyService.findById(id);
	}
	
	@PostMapping("/faculties/addNew")//adding a new faculty
	public void AddFaculty(@RequestBody Faculty faculty) {
		facultyService.addFaculty(faculty);
	}
	@PutMapping("/faculties/{id}/update")//updating faculties detail
	public void UpdateFaculty(@RequestBody Faculty faculty) {
		facultyService.updateFaculty(faculty);
	}
	@DeleteMapping("/faculties/{id}/delete")//deleting faculty by id
	public void DeleteFaculty(@PathVariable Integer id) {
		facultyService.deleteFaculty(id);
	}
}
