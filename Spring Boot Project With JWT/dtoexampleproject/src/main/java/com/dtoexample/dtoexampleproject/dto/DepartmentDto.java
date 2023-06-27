package com.dtoexample.dtoexampleproject.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.dtoexample.dtoexampleproject.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it is used to generate Getter and Setter.
@NoArgsConstructor // Generate No Argument Constructor.
@AllArgsConstructor // Generate Parameterized Constructor.
public class DepartmentDto {

	@NotNull
	private int dtodid;
	@NotNull
	private String dtodname;
	
	@OneToMany(mappedBy="dpm")
	private List<Employee> emp;
}
