package com.dtoexample.dtoexampleproject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity // create a Department Table in database.
@Data // generate a Getter and Setter.
public class Department {

	@Id // it is used to give a primary key to the field.
	@NotNull(message="Department Id is Not Null.") //
	private int did; // Department Id
	@NotNull(message="Department Name is Not Null.")
	private String dname; // Department Name
	
	@OneToMany(mappedBy="dpm") // it used to mapped the tables like OneToOne.
	@JsonManagedReference // It is used to managed the response given from Postman / Browser.
	private List<Employee> emp; // Create a Employee Object with List.
}
