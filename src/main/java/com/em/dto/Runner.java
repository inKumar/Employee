package com.em.dto;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class Runner {

	public static void main(String[] args) {
			
		CompanyDto company1= new CompanyDto();
		company1.setName("Jspiders");
		
		  DepartmentDto depart1 = new DepartmentDto(); depart1.setComp(company1);
		  depart1.setName("development"); depart1.setNoOfEmps(41);
		  
		  DepartmentDto depart2 = new DepartmentDto(); depart2.setComp(company1);
		  depart2.setName("testing"); depart2.setNoOfEmps(65);
		  
		  
		  
		  EmployeeDto emp1 = new EmployeeDto(); emp1.setCompany(company1);
		  emp1.setDepartment(depart1); emp1.setActive(true); emp1.setDateOfJoing(new
		  Date(2019 , 11 ,1)); emp1.setDob(new Date(1994, 2, 21));
		  emp1.setFirstName("kiran"); emp1.setLastName("sharma");
		  emp1.setLoginId("kiran123"); emp1.setPassword("user"); emp1.setRole("user");
		  
		  
		  EmployeeDto emp2 = new EmployeeDto(); emp2.setCompany(company1);
		  emp2.setDepartment(depart1); emp2.setActive(true); emp2.setDateOfJoing(new
		  Date(2018 , 9 ,10)); emp2.setDob(new Date(1991, 4, 1));
		  emp2.setFirstName("rahul"); emp2.setLastName("jetly");
		  emp2.setLoginId("rahul321"); emp2.setPassword("user"); emp2.setRole("user");
		  
		  EmployeeDto emp3 = new EmployeeDto(); emp3.setCompany(company1);
		  emp3.setDepartment(depart2); emp3.setActive(true); emp3.setDateOfJoing(new
		  Date(2016 , 11 ,4)); emp3.setDob(new Date(1990, 8, 30));
		  emp3.setFirstName("dhanush"); emp3.setLastName("raj");
		  emp3.setLoginId("raj007"); emp3.setPassword("user"); emp3.setRole("admin");
		  
		  EmployeeDto emp4 = new EmployeeDto(); emp4.setCompany(company1);
		  emp4.setDepartment(depart2); emp4.setActive(true); emp4.setDateOfJoing(new
		  Date(2018 , 4 ,9)); emp4.setDob(new Date(1993, 5, 28));
		  emp4.setFirstName("pooja"); emp4.setLastName("sharma");
		  emp4.setLoginId("pooja123"); emp4.setPassword("user"); emp4.setRole("user");
		  
		  
		  // for comapny 1
		  List<DepartmentDto> listOfDepts = company1.getListOfDepts();
		  listOfDepts.add(depart1); listOfDepts.add(depart2);
		  
		  List<EmployeeDto> listOfEmps = company1.getListOfEmps();
		  listOfEmps.add(emp1); listOfEmps.add(emp2); listOfEmps.add(emp3);
		  listOfEmps.add(emp4);
		  
		  
		  List<EmployeeDto> listOfEmpsfordept1 = depart1.getListOfEmps();
		  listOfEmpsfordept1.add(emp1); listOfEmpsfordept1.add(emp2);
		  
		  List<EmployeeDto> listOfEmpsfordept2 = depart2.getListOfEmps();
		  listOfEmpsfordept2.add(emp3); listOfEmpsfordept2.add(emp4);
		  
		 	
		Configuration configuration = new Configuration();
		configuration.configure(new File("src/main/webapp/WEB-INF/hibernate.cfg.xml"));
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(company1);
		
		session.getTransaction().commit();
		
	}
	
}
