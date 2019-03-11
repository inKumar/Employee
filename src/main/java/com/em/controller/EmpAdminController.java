package com.em.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class EmpAdminController {

	
	@Autowired
	EmployeeServiceInterface serviceImpl;

	Logger logger = Logger.getLogger(EmployeeController.class);

	@GetMapping("/saveEmp")
	public String saveEmp(HttpSession session, Model model) {
		EmployeeDto dto = (EmployeeDto)session.getAttribute("emptoDto");
		if (dto==null) {
			return "login";
		}
		
		return "saveEmpPage";
	}
	
	@PostMapping("/addNewEmp")
	public String addNewEmp(HttpSession session, Model model) {
		
		
		
		
		return "saveEmpPage";
	}
	
	
}
