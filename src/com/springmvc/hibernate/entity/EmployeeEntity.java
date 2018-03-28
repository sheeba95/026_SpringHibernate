package com.springmvc.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {	
	@Id
	@Column(name="empid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;  
	
	@Column(name="empName")
	private String employeeName;  
	
	@Column(name="empSalary")
	private float employeeSalary;
	
	@Column(name="empDesignation")
	private String employeeDesignation;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public float getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public EmployeeEntity(int id, String employeeName, float employeeSalary, String employeeDesignation) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeDesignation = employeeDesignation;
	}
	
	public EmployeeEntity() {
		
	}
}