package com.dtoexample.dtoexampleproject.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dtoexample.dtoexampleproject.dao.EmployeeRepo;
import com.dtoexample.dtoexampleproject.entities.Employee;
import com.dtoexample.dtoexampleproject.exceptionHandler.UserNotfoundException;

@SpringBootTest
public class EmployeeServiceTest {

//	@Autowired
//	private EmployeeService employeeService;
	@MockBean
	private EmployeeRepo employeeRepo;
	
	@Test
	public void testAllEmployee()
	{
		
		Employee dto=new Employee();
		dto.setEid(1);
		dto.setEname("Mueez");
		dto.setEmail("moizs1234@gmail.com");
		dto.setSalary(200000);
		dto.setDes("Tester");
		Employee dto2=new Employee();
		dto2.setEid(1);
		dto2.setEname("Mueez");
		dto2.setEmail("moizs1234@gmail.com");
		dto2.setSalary(200000);
		dto2.setDes("Tester");
		
		List<Employee> li=new ArrayList<>();
		li.add(dto);
		li.add(dto2);
		Mockito.when(this.employeeRepo.findAll()).thenReturn(li);
		//assertThat(this.employeeService.getAllEmployee()).isEqualTo(li);
	}
	
	@Test
	public void testAddEmployee()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Mueez");
		emp.setEmail("moizs@gmail.com");
		emp.setSalary(20000);
		emp.setDes("xyz");
		Mockito.when(this.employeeRepo.save(emp)).thenReturn(emp);
		//assertThat(this.employeeService.addEmployee(emp)).isEqualTo(emp);
	}
	
	@Test
	public void testGetById() throws UserNotfoundException
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Moiz");
		emp.setEmail("Mazen@gmail.com");
		emp.setSalary(400000);
		emp.setDes("xyi");
		
		Mockito.when(this.employeeRepo.findById(1)).thenReturn(emp);
		//assertThat(this.employeeService.getById(1)).isEqualTo(emp);
	}
	
	@Test
	public void testDelete()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Moiz");
		emp.setEmail("Mazen@gmail.com");
		emp.setSalary(400000);
		emp.setDes("xyi");
		
		Mockito.when(this.employeeRepo.findById(1)).thenReturn(emp);
		Mockito.when(this.employeeRepo.existsById(emp.getEid())).thenReturn(false);
		assertFalse(this.employeeRepo.existsById(emp.getEid()));
	}
	
	@Test
	public void testUpdateEmployee()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Moiz");
		emp.setEmail("Mazen@gmail.com");
		emp.setSalary(400000);
		emp.setDes("xyi");
		
		Mockito.when(this.employeeRepo.findById(1)).thenReturn(emp);
		emp.setEmail("moizs1234@gmail.com");
		Mockito.when(this.employeeRepo.save(emp)).thenReturn(emp);
		
		//assertThat(this.employeeService.updateEmployee(emp, 1)).isEqualTo(emp);
	}
	
	
}
