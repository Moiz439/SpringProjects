package com.dtoexample.dtoexampleproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // it is used to create a table in Database.
@Data // it is used to generate getter and setter
@NoArgsConstructor // it is a no argument or no parameterized constructor.
@AllArgsConstructor // it is a argument type constructor 
@Table(name="employee_table")
public class Employee {

	@Id  // it is used to give a primary key to the field.
	@NotNull(message = "Employee Id should'nt be Null.")
	private int eid; // employee id
	@NotNull(message = "Employee Name should'nt be Null." )
	private String ename; // employee Name
	@Email(message ="Invalid Email Id.")
	private String email; // Employee email
	@NotNull(message ="Salary should'nt be null.")
	private int salary; // Employee Salary
	@NotNull(message ="Designation should'nt be null.")
	private String des; // Employee Designation

	@ManyToOne  // it is used to ManyToOne Mapping or join the 2 tables.
	@JsonBackReference // it is used get Reference back from the browser/ Postman.
	
	private Department dpm; // create a Department object.
}
