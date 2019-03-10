package com.em.service;

import java.util.List;

import com.em.dto.EmployeeDto;
import com.em.dto.PostDto;

public interface EmployeeServiceInterface {
	
	/*
	 * public Long saveEmployee(EmployeeDto employee); public int
	 * deleteEmployee(EmployeeDto employee); public EmployeeDto getEmployee(Long
	 * id); public EmployeeDto updateEmployee(EmployeeDto employee);
	 */
	public EmployeeDto getEmpByLoginId(String loginId );

	public EmployeeDto updateEmp(EmployeeDto empfromJSP);

	public List<PostDto> getAllPost();
}
