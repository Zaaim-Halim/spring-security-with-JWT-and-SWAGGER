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

import com.example.CollegeManagementSystem.entities.College;
import com.example.CollegeManagementSystem.entities.Department;
import com.example.CollegeManagementSystem.sevice.CollegeService;

@RestController

@RequestMapping("/api")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
		
	@GetMapping("/colleges")//list of college details
	public List<College> getAllLocations() {
		return collegeService.findAll();
	}
		
	@GetMapping("/colleges/{id}")//college detail by id
	public Optional<College> getLocationById(@PathVariable Integer id) {
		return collegeService.findById(id);
	}
	@GetMapping("/colleges/{id}/departments")//departments by college id
	public List<Department> GetDepartmentsByCollege(@PathVariable Integer id) {
	    Optional<College> college = collegeService.findById(id);		
	    if(college.isPresent()) {
		return college.get().getDepartments();
	    }		
	    return null;
	}
	@PostMapping("/colleges/addNew")//adding new college
	public void AddCollege(@RequestBody College college) {
		collegeService.AddCollege(college);
	}
	@PutMapping("/colleges/{id}/update")// update college details
	public void UpdateCollege(@RequestBody College college) {
		collegeService.UpdateCollege(college);
	}
	@DeleteMapping("/colleges/{id}/delete")//delete college by id
	public void DeleteCollege(@PathVariable Integer id) {
		collegeService.deleteCollege(id);
	}
}
