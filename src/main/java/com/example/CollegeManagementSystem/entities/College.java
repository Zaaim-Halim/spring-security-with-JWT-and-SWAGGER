package com.example.CollegeManagementSystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class College {

	@Id
	 private Integer id;
	 private String name;
	 
	 @OneToMany(mappedBy="college", cascade = CascadeType.ALL)
	 private List<Department> departments;
	 
	 @JsonManagedReference
	 public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public College() {
		 
	 }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public College(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	 
}
