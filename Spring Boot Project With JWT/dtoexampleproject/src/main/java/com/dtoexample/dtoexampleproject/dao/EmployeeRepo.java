package com.dtoexample.dtoexampleproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dtoexample.dtoexampleproject.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{ // it provide the Crud Operations.

	public Employee findById(int id); // it is used to fetch the data by Id.
}
