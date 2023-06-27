package com.dtoexample.dtoexampleproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dtoexample.dtoexampleproject.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{ // in that they provide the Crud Operations.

	public Department findById(int id); // it is a findById method to fetch the data by using Id.
}
