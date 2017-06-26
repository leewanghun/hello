package com.test.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.test.jaxb")
//@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

	private String deptNumber;
	private String deptName;
	private String location;

	@XmlElementWrapper(name = "employees")
	@XmlElement(name = "employee")
	private List<Employee> employees;
	
	public Department() {
	}


	public Department(String deptNo, String deptName, String location) {
		this.deptNumber = deptNo;
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNumber;
	}

	public void setDeptNo(String deptNo) {
		this.deptNumber = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
