package com.example.CollegeManagementSystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {

	@Id
	private Integer id;
	private String deptname;
	@ManyToOne
	@JoinColumn(name="collegeid", insertable=false, updatable=false)
	private College college;
	
	private Integer collegeid;
	
	
	public Integer getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Faculty> faculties;
	
	@JsonManagedReference
	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	public Department(Integer id, String deptname, College college) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.college = college;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@JsonBackReference
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Department() {
		
	}
}
