package com.dtoexample.dtoexampleproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dtoexample.dtoexampleproject.converter.EmployeeConverter;
import com.dtoexample.dtoexampleproject.dao.EmployeeRepo;
import com.dtoexample.dtoexampleproject.dto.EmployeeDto;
import com.dtoexample.dtoexampleproject.entities.Employee;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;


@Component // it is used to provide the connection to use the @Autowired the files easily in file.
public class EmployeeService { //class

	@Autowired // it automatically provide the connection with EmployeeRepo.
	private EmployeeRepo employeeRepo;
	
	@Autowired EmployeeConverter converter; // it automatically provide the connection with EmployeeConvertor.
			
	// this method is create to fetch all data from database.
	public List<EmployeeDto> getAllEmployee()
	{
		List<Employee> emp=(List<Employee>)this.employeeRepo.findAll(); // fetch all data from the data table and store in List variable.
		return this.converter.entityToDto(emp); // convert entity to dto.
	}
    
	// this method is create for Add the New Employee into the database.
	public EmployeeDto addDepartment(EmployeeDto dto)
	{
		Employee emp=this.converter.dtoToEntity(dto); // convert dto to entity
		Employee result=this.employeeRepo.save(emp); // save into the data table.
		return this.converter.entityToDto(result); // convert entity to dto.
	}
	
	// this method is created for get Employee Data by using Id.
	public EmployeeDto getById(int id) throws UserNotfoundException // throw the exception.
	{
		Employee emp=this.employeeRepo.findById(id); // fetch the data from the table by using Id.
		 
		if(emp!=null) // if emp is not null the condition is true the execute if block.
		{ 
			return this.converter.entityToDto(emp); // convert entity to dto.
		}
		else
		{
			
			throw new UserNotfoundException("User Not Found with id :"+id ); // it throw the UserNotFoundException if the condition is false
			
		}
	}
	// this method is created for delete data from table.
	public void deleteEmployee(int id)
	{
		this.employeeRepo.deleteById(id); // delete the data from table y using Id
	}
	// this method is used to update data from the table by using Id.
	public EmployeeDto updateEmployee(EmployeeDto dto,int id)
	{
		Employee emp1=this.employeeRepo.findById(id);// create a Employee clas object.
		emp1.setEid(dto.getDtoeid()); // set Eid.
		emp1.setEname(dto.getDtoename()); // set Ename.
		emp1.setEmail(dto.getDtoemail()); // set Email.
		emp1.setSalary(dto.getDtosalary()); // set Salary.
		emp1.setDes(dto.getDtodes()); // set Designation.
		this.employeeRepo.save(emp1); //Save data into the table.
		return this.converter.entityToDto(emp1); // convert entity to dto.
	}
	
	
	
}
