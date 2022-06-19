package com.example.CollegeManagementSystem.reposittories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeManagementSystem.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>{

}
