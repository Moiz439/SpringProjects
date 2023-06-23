package com.dtoexample.dtoexampleproject.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dtoexample.dtoexampleproject.dto.EmployeeDto;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;
import com.dtoexample.dtoexampleproject.service.EmployeeService;

@Controller  // it is a Controller to connect with browser/postman.
public class EmployeeController { //class

	@Autowired EmployeeService employeeService; // it automatically provide the connection with EmployeeService Class.
	
	@GetMapping("/employee") // this Mapping used to get All Deta from Database.
	public ResponseEntity<List<EmployeeDto>> getAll() // list of data fetch
	{
		return ResponseEntity.ok(this.employeeService.getAllEmployee()); // return all employee data.
	}
	
	@GetMapping("/employee/{id}") // this Mapping used to get All Deta from Database.
	public ResponseEntity<EmployeeDto> getById(@PathVariable("id") int id) throws UserNotfoundException // it fetch data from database by using Id and throw the UserExaception.
	{
		return ResponseEntity.ok(this.employeeService.getById(id)); // return Data by using Id.
	}
	
	@PostMapping("/employee") // This Mapping is used to Insert new Data into the Table 
	public ResponseEntity<EmployeeDto> addDepartment1(@Valid @RequestBody EmployeeDto dto)// Check the validation .
	{
		EmployeeDto dto1=this.employeeService.addDepartment(dto); // Create a EmployeeDto Object
		return new ResponseEntity<>(dto1,HttpStatus.CREATED); // give a HttpSatatus on PostMan.
	}
	
	@DeleteMapping("/employee/{id}") // this Mapping is used to Delete Data From Database Table. by using id.
	public ResponseEntity<String> delete(@PathVariable("id") int id) // convert Parameters in Integer.
	{
		this.employeeService.deleteEmployee(id); // Delete 
		return ResponseEntity.ok("Department Deleted."); 
	}
	
	@PutMapping("/employee/{id}")// this Mapping is used to update the data from table.
	public EmployeeDto updateDepartment(@RequestBody EmployeeDto dto,@PathVariable("id") int id) // convert data types.
	{
		return this.employeeService.updateEmployee(dto, id); // return updated Data.
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
