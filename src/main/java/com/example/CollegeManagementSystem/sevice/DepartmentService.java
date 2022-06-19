package com.example.CollegeManagementSystem.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.CollegeManagementSystem.entities.Department;
import com.example.CollegeManagementSystem.reposittories.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return (List<Department>) departmentRepository.findAll();
	}

	public Optional<Department> getDepartmentsById(Integer id) {
		return departmentRepository.findById(id);
	}
	public void addDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	public void updateDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	public void deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);
		
	}

	

}
