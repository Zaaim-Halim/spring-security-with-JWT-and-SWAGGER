package com.example.CollegeManagementSystem.reposittories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeManagementSystem.entities.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,Integer>{

}
