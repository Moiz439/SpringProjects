package com.dtoexample.dtoexampleproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dtoexample.dtoexampleproject.dto.EmployeeDto;
import com.dtoexample.dtoexampleproject.entities.Employee;

@Component  // it is used to provide the connection to use the @Autowired the files easily in file.
public class EmployeeConverter {

	// This Method is created to convert Entity Class into Dto class.
	public EmployeeDto entityToDto(Employee emp)
	{
		EmployeeDto dto=new EmployeeDto(); // create a EmployeeDto object.
		dto.setDtoeid(emp.getEid());  // set fields.
		dto.setDtoename(emp.getEname());
		dto.setDtoemail(emp.getEmail());
		dto.setDtosalary(emp.getSalary());
		dto.setDtodes(emp.getDes());
		dto.setDpm(emp.getDpm());
		return dto; // return dto object.
	}
	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<EmployeeDto> entityToDto(List<Employee> emp)
	{
		return emp.stream().map(x-> entityToDto(x)).collect(Collectors.toList()); // list of object are converted .
	}
	// This Method is created to convert Dto Class into Entity class.
	public Employee dtoToEntity(EmployeeDto dto)
	{
		Employee emp=new Employee(); // create a Employee Class Object.
		emp.setEid(dto.getDtoeid()); // set fields.
		emp.setEname(dto.getDtoename());
		emp.setEmail(dto.getDtoemail());
		emp.setSalary(dto.getDtosalary());
		emp.setDes(dto.getDtodes());
		emp.setDpm(dto.getDpm());
		return emp; // return emp object.
	}
	// This Method is created to convert List of Dto Class into List of Entity class.
	public List<Employee> dtoToEntity(List<EmployeeDto> dto)
	{
		return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList()); // list of object are concerted.
	}
}
