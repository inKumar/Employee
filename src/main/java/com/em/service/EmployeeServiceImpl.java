package com.em.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.dao.EmployeeDaoImpl;
import com.em.dao.EmployeeDaoInterface;
import com.em.dto.EmployeeDto;
import com.em.dto.PostDto;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	EmployeeDaoInterface daoImpl;

	public EmployeeDto getEmpByLoginId(String loginId) {
		return daoImpl.getEmpByLoginId(loginId);
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto empfromJSP) {
		
		EmployeeDto dto = daoImpl.updateEmp(empfromJSP);
		return dto;
	}

	@Override
	public List<PostDto> getAllPost() {
		
		
		return daoImpl.getAllPost();
	}

}
