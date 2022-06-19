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

import com.example.CollegeManagementSystem.entities.Department;
import com.example.CollegeManagementSystem.entities.Faculty;
import com.example.CollegeManagementSystem.sevice.DepartmentService;



@RestController


@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@GetMapping("/departments")//list of departments
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	@GetMapping("/departments/{id}")//departments detail by id
	public Optional<Department> getDepartmentsById(@PathVariable Integer id) {
	    return departmentService.getDepartmentsById(id);
	}
	@GetMapping("/departments/{id}/faculties")//list of faculties by department id
	public List<Faculty> getFacultiesByDepartment(@PathVariable Integer id) {
	    Optional<Department> department = departmentService.getDepartmentsById(id);
	    if(department.isPresent()) {
		return department.get().getFaculties();
	    }
	    return null;
	}
	@PostMapping("/departments/addNew")//adding new department
	public void AddDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}
	@PutMapping("/departments/{id}/update")//updating department details
	public void UpdateDepartment(@RequestBody Department department ) {
		departmentService.updateDepartment(department);
	}
	@DeleteMapping("/departments/{id}/delete")//deleting department by id
	public void DeleteDepartment(@PathVariable Integer id) {
		departmentService.deleteDepartment(id);
	}
}
