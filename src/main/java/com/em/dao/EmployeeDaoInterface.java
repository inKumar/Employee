package com.em.dao;

import java.util.List;

import com.em.dto.EmployeeDto;
import com.em.dto.PostDto;

public interface EmployeeDaoInterface {
	public EmployeeDto getEmpByLoginId(String loginId );

	public EmployeeDto updateEmp(EmployeeDto empfromJSP);

	public List<PostDto> getAllPost();
}
