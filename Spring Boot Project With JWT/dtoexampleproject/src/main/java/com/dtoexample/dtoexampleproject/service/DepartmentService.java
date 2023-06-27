package com.dtoexample.dtoexampleproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dtoexample.dtoexampleproject.converter.DepartmentConverter;
import com.dtoexample.dtoexampleproject.dao.DepartmentRepo;
import com.dtoexample.dtoexampleproject.dto.DepartmentDto;
import com.dtoexample.dtoexampleproject.entities.Department;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;

@Component // it is used to provide the connection to use the @Autowired the files easily in file.
public class DepartmentService {

	@Autowired // it automatically provide the connection with DepartmentRepo.
	private DepartmentRepo departmentRepo;
	
	@Autowired // it automatically provide the connection with DepartmentService.
	private DepartmentConverter converter;
	
	// this method is create to fetch all data from database.
	public List<DepartmentDto> getAllDep()
	{
		List<Department> li=(List<Department>)this.departmentRepo.findAll();
		return this.converter.entityToDto(li);
	}
	// this method is created for get Department Data by using Id.
	public DepartmentDto getById(int id) throws UserNotfoundException
	{
		Department dp=this.departmentRepo.findById(id);
		if(dp!=null)
		return this.converter.entityToDto(dp);
		else
			throw new UserNotfoundException("User Not Found with id :"+id );
	}
	// this method is create for Add the New Department into the database.
	public DepartmentDto addDepartment(DepartmentDto dto)
	{
		Department dpm=this.converter.dtoToEntity(dto);
		Department result=this.departmentRepo.save(dpm);
		return this.converter.entityToDto(result);
	}
	
	// this method is used to delete data from table by using Id.
	public String deleteDepartment(int id)
	{
		this.departmentRepo.deleteById(id); // delete the data from the table .
		return "deleted";
	}
	// this method is used to Update data from the Table by using Id
	public DepartmentDto updateDepartment(DepartmentDto dto,int id)
	{
		Department dpm=this.departmentRepo.findById(id); // Create a Department Object and fetch the data from the table.
		dpm.setDid(dto.getDtodid()); // set the Did
		dpm.setDname(dto.getDtodname()); // set the Dname
		dpm.setEmp(dto.getEmp()); // set Employee
		this.departmentRepo.save(dpm); // save data into the table.
		return this.converter.entityToDto(dpm); // convert entity to dto.
	}
	
	
}
