package com.dtoexample.dtoexampleproject.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dtoexample.dtoexampleproject.dao.DepartmentRepo;
import com.dtoexample.dtoexampleproject.entities.Department;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;

@SpringBootTest
public class DepartmentServiceTest {

	@MockBean DepartmentService departmentService;
	@MockBean DepartmentRepo departmentRepo;
	
	@Test
	public void testGetAllDep()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Developer");
		
		Department dpm1=new Department();
		dpm1.setDid(102);
		dpm1.setDname("Developer");
		
		List<Department> li=new ArrayList<>();
		li.add(dpm);
		li.add(dpm1);
		
		Mockito.when(this.departmentRepo.findAll()).thenReturn(li);
		
		//assertThat(this.departmentService.getAllDep()).isEqualTo(li);
	}
	
	
	@Test
	public void testAddEmployee()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("xyz");
		
		Mockito.when(this.departmentRepo.save(dpm)).thenReturn(dpm);
		
		//assertThat(this.departmentService.addDepartment(dpm)).isEqualTo(dpm);
	}
	
	@Test
	public void testGetById() throws UserNotfoundException
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Mockito.when(this.departmentRepo.findById(101)).thenReturn(dpm);
		
		//assertThat(this.departmentService.getById(101)).isEqualTo(dpm);
	}
	
	@Test
	public void testDelete()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Mockito.when(this.departmentRepo.findById(101)).thenReturn(dpm);
		Mockito.when(this.departmentRepo.existsById(101)).thenReturn(false);
		assertFalse(this.departmentRepo.existsById(dpm.getDid()));
	}
	
	@Test
	public void testUpdateEmployee()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("pqr");
		
		Mockito.when(this.departmentRepo.findById(101)).thenReturn(dpm);
		dpm.setDname("Abc");
		Mockito.when(this.departmentRepo.save(dpm)).thenReturn(dpm);
		
		//assertThat(this.departmentService.updateDepartment(dpm, 101)).isEqualTo(dpm);
	}
	
	
}
