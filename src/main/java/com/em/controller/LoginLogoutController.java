package com.em.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.em.dto.EmployeeDto;
import com.em.service.EmployeeServiceInterface;
@Controller
@SessionAttributes("empDto")
public class LoginLogoutController {
	
	
	
	
	@Autowired
	EmployeeServiceInterface serviceImpl;

	Logger logger = Logger.getLogger(EmployeeController.class);

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("index", "Model test is working");
		return "login";
	}
	
	@PostMapping(value = "/loginEmp")
	// @RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
	public String login(@RequestParam String loginId, @RequestParam String password, Model model) {

		EmployeeDto empFromDb = serviceImpl.getEmpByLoginId(loginId);

		model.addAttribute("empDto", empFromDb);
		// model.addAttribute("test", "testvalue");
		
		System.out.println(empFromDb);
		if (password.equals(empFromDb.getPassword())) {
			if (empFromDb.getRole().equals("admin")) {
				model.addAttribute("welcome",
						"welcome " + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());

				return "adminpage";
			}
			if (empFromDb.getRole().equals("user")) {
				model.addAttribute("welcome",
						"welcome" + empFromDb.getFirstName() + "" + " " + empFromDb.getLastName());
				return "userpage";
			}
		}
		return "login";
	}

	
	//logout not working
	
		@GetMapping("/logout")
		public String logout(Model model, SessionStatus status) {
		
			status.setComplete();
			return "login"; 
		}
	
	
	

}
