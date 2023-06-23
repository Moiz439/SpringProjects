package com.dtoexample.dtoexampleproject.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dtoexample.dtoexampleproject.dto.DepartmentDto;
import com.dtoexample.dtoexampleproject.entities.Department;

@Component // it is used to provide the connection to use the @Autowired the files easily in file.
public class DepartmentConverter {

	// This Method is created to convert Entity Class into Dto class.
	public DepartmentDto entityToDto(Department dpm)
	{
		DepartmentDto dto=new DepartmentDto(); // create DepartmentDto Object.
		dto.setDtodid(dpm.getDid()); // set Fields.
		dto.setDtodname(dpm.getDname());
		dto.setEmp(dpm.getEmp());
		return dto; // return dto object.
	}
	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<DepartmentDto> entityToDto(List<Department> dpm)
	{
		return dpm.stream().map(x-> entityToDto(x)).collect(Collectors.toList()); // convert all objects.
	}
	// This Method is created to convert Dto Class into Entity class.
	public Department dtoToEntity(DepartmentDto dto)
	{
		Department dpm=new Department(); // create Department Object.
		dpm.setDid(dto.getDtodid()); // set Fields.
		dpm.setDname(dto.getDtodname());
		dpm.setEmp(dto.getEmp());
		return dpm; // return dpm object.
	}
	// This Method is created to convert List of Dto Class into List of Entity class.
	public List<Department> dtoToEntity(List<DepartmentDto> dto)
	{
		return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());  // convert all object .
	}
}
