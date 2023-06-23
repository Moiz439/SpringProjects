package com.dtoexample.dtoexampleproject.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.dtoexample.dtoexampleproject.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it is used to generate Getter and Setter.
@NoArgsConstructor // Generate No Argument Constructor.
@AllArgsConstructor // Generate Parameterized Constructor.
public class EmployeeDto { // EmployeeDto Class.

	@NotNull 
	private int dtoeid;
	@NotNull
	private String dtoename;
	@Email
	private String dtoemail;
	@NotNull
	private int dtosalary;
	@NotNull
	private String dtodes;

	@ManyToOne
	private Department dpm;
}
