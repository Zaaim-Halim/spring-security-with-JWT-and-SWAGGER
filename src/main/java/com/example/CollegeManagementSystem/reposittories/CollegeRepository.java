package com.example.CollegeManagementSystem.reposittories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeManagementSystem.entities.College;

@Repository
public interface CollegeRepository extends CrudRepository<College,Integer>{

}
