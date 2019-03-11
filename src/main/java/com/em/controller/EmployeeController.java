
package com.em.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.em.dto.EmployeeDto;
import com.em.dto.PostDto;
import com.em.service.EmployeeServiceImpl;
import com.em.service.EmployeeServiceInterface;

@Controller
@SessionAttributes("empDto")
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface serviceImpl;

	Logger logger = Logger.getLogger(EmployeeController.class);

	
	
	

	@GetMapping("/index")
	
	public String getIndex(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto!=null) {
			return "index";
		}
		
		return "login";
	}
	@GetMapping("/account")
	public String getUserPage(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto!=null) {
			return "userpage";
		}
		
		return "login";
	}
	@GetMapping("/profile")
	public String getProfile(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto!=null) {
			return "profilepage";
		}
		
		return "login";
		
		
	}
	@GetMapping("/showPosts")
	public String showPosts(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto!=null) {
			int a=1;
			model.addAttribute("switchNav", a);
			List<PostDto> list = serviceImpl.getAllPost();
			model.addAttribute("postsList", list);
			
					
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getPostEmp().getCompany().getName());
				System.out.println(list.get(i).getPostContents());
				return "homepage";
			}
		}
		
		return "login";
	}
	@GetMapping("/showProfile")
	public String showProfile(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto==null){
			return "login";
		}
		int a=2;
		model.addAttribute("switchNav", a);
		
		return "homepage";
	}
	@GetMapping("/showMessages")
	public String showMessages(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto==null){
			return "login";
		}
		int a=3;
		model.addAttribute("switchNav", a);
		
		return "homepage";
	}
	
	
	
	
	
	

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	String saveEmployee(@ModelAttribute EmployeeDto employee, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		return "employeeDetails";
	}

	public EmployeeController() {
		System.out.println("emp comtroller created");
	}

	
	// @GetMapping("/userProfile")
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String userprofile(Model model, HttpSession session) {

		Object object = session.getAttribute("empDto");
		EmployeeDto emp = (EmployeeDto) object;
		
		model.addAttribute("emp", emp);

		return "profilepage";
	}

	// @GetMapping("/udateProfile")
	@RequestMapping(value = "/udateProfile", method = RequestMethod.GET)
	public String updateprofile(Model model, HttpSession session) {

		Object object = session.getAttribute("empDto");
		EmployeeDto emp = (EmployeeDto) object;
		model.addAttribute("emp", emp);

		return "EmpUpdatePage";
	}


	
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute EmployeeDto empfromJSP, BindingResult bindingResult, Model model,
			HttpSession session) {
		
		
		
		
		if (bindingResult.hasErrors()) {
			
			String s = bindingResult.getFieldError().getField();
			String errmsg = s+" Feild has error !! Try Again";
			System.out.println("Printing error msg--->"+errmsg);
			model.addAttribute("error",errmsg );
			

			Object object = session.getAttribute("empDto");
			EmployeeDto emp = (EmployeeDto) object;
			model.addAttribute("emp", emp);
			
			return "EmpUpdatePage";

		}
		System.out.println("No error Detected");
		System.out.println(empfromJSP);
		Object object = session.getAttribute("empDto");
		EmployeeDto emp = (EmployeeDto) object;
		
		empfromJSP.setCompany(emp.getCompany());
		empfromJSP.setDepartment(emp.getDepartment());
		empfromJSP.setId(emp.getId());
		empfromJSP.setRole(emp.getRole());
		
				
		EmployeeDto dto =serviceImpl.updateEmp(empfromJSP);
		model.addAttribute("empDto", dto);
		String updateStatusMsg ="Your account credientials updated sucessfully !";
		model.addAttribute("updateStatusMsg", updateStatusMsg);
		return "profilepage";
	}

	@GetMapping("/home")
	
	public String getHomePage(Model model, HttpSession session) {
		EmployeeDto dto = (EmployeeDto) session.getAttribute("empDto");
		if(dto==null){
			return "login";
			
		}
		int a=1;
		model.addAttribute("switchNav", a);
		List<PostDto> list = serviceImpl.getAllPost();
		model.addAttribute("postsList", list);
		
				
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPostEmp().getCompany().getName());
			System.out.println(list.get(i).getPostContents());
			
		}
		
		
		return "homepage";
	}
	
	
	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public String savePost(@ModelAttribute PostDto postDtofromJSP, BindingResult bindingResult, Model model,
			HttpSession session) {
		

		if (bindingResult.hasErrors()) {
			
			String s = bindingResult.getFieldError().getField();
			String errmsg = s+" Feild has error !! Try Again";
			System.out.println("Printing error msg--->"+errmsg);
			model.addAttribute("postError",errmsg );
			
			
			return "userpage";

		}
		System.out.println("-----> Execuring savePost");
		
		Object object = session.getAttribute("empDto");
		EmployeeDto emp = (EmployeeDto) object;
		
		PostDto postDto = postDtofromJSP;
		postDto.setAuthorCompany(emp.getCompany().getName());
		String name = emp.getFirstName()+" "+emp.getLastName();
		postDto.setAuthorName(name);
		postDto.setPostContents(postDtofromJSP.getPostContents());
		postDto.setPostEmp(emp);
		postDto.setPostColor(postDtofromJSP.getPostColor());
		
		
		List<PostDto> listsOfposts = new ArrayList<PostDto>();
		listsOfposts.add(postDto);
		
		emp.setListsOfposts(listsOfposts);
		
		EmployeeDto dto =serviceImpl.updateEmp(emp);
		model.addAttribute("empDto", dto);
		String updateStatusMsg ="Your post sucessfully updated  !";
		model.addAttribute("postStatus", updateStatusMsg);
		
		
		return "userpage";
	}
	
	
	
	
	
	
	
}
