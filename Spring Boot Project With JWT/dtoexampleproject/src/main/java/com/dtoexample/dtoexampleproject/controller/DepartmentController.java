package com.dtoexample.dtoexampleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtoexample.dtoexampleproject.dto.DepartmentDto;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;
import com.dtoexample.dtoexampleproject.service.DepartmentService;

@Controller // it is a Controller to connect with browser/postman.
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dpm")
public class DepartmentController {

	@Autowired DepartmentService departmentService;// it automatically provide the connection with DepartmentService Class.
	
	
	@GetMapping("/department") // this Mapping used to get All Deta from Database.
	public ResponseEntity<List<DepartmentDto>> getAll()
	{
		return ResponseEntity.ok(this.departmentService.getAllDep());
	}
	
	@GetMapping("/department/{id}") // this Mapping used to get All Deta from Database.
	public ResponseEntity<DepartmentDto> getById(@PathVariable("id") int id) throws UserNotfoundException
	{
		return ResponseEntity.ok(this.departmentService.getById(id));
	}
	
	@PostMapping("/department")// This Mapping is used to Insert new Data into the Table 
	public ResponseEntity<DepartmentDto> addDepartment1(@RequestBody DepartmentDto dto)
	{
		DepartmentDto dto1=this.departmentService.addDepartment(dto);
		return new ResponseEntity<>(dto1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/department/{id}")// this Mapping is used to Delete Data From Database Table. by using id.
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
		this.departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Department Deleted.");
	}
	
	@PutMapping("/department/{id}")// this Mapping is used to update the data from table.
	public DepartmentDto updateDepartment(@RequestBody DepartmentDto dto,@PathVariable("id") int id)
	{
		return this.departmentService.updateDepartment(dto, id);
	}
}
