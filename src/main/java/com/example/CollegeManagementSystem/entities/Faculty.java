package com.example.CollegeManagementSystem.entities;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
public class Faculty {

	@Id
	private Integer id;
	private String facultyname;
	private String role;
	@ManyToOne
	@JoinColumn(name="departmentid", insertable=false, updatable=false)
	private Department department;
	
	private Integer departmentid;
	
	public Integer getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}


	public Faculty(Integer id, String facultyname, String role, Department department) {
		super();
		this.id = id;
		this.facultyname = facultyname;
		this.role = role;
		this.department = department;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFacultyname() {
		return facultyname;
	}


	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@JsonBackReference
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Faculty() {
		
	}
}
