package com.em.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "table_departments")
public class DepartmentDto {
	

	@Id
	@GenericGenerator(name = "gen" , strategy = "increment")
	@GeneratedValue(generator ="gen")
	private long id;
	
	@Column(name = "dpt_name")
	private String name;
	
	@Column(name = "no_of_emps")
	private int noOfEmps;
	
	@OneToMany(mappedBy ="department" ,cascade = CascadeType.ALL)
	List<EmployeeDto> listOfEmps = new ArrayList<EmployeeDto>();
	
	@ManyToOne
	CompanyDto comp;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEmps() {
		return noOfEmps;
	}

	public void setNoOfEmps(int noOfEmps) {
		this.noOfEmps = noOfEmps;
	}

	public List<EmployeeDto> getListOfEmps() {
		return listOfEmps;
	}

	public void setListOfEmps(List<EmployeeDto> listOfEmps) {
		this.listOfEmps = listOfEmps;
	}

	public CompanyDto getComp() {
		return comp;
	}

	public void setComp(CompanyDto comp) {
		this.comp = comp;
	}

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto(String name, int noOfEmps, List<EmployeeDto> listOfEmps, CompanyDto comp) {
		super();
		this.name = name;
		this.noOfEmps = noOfEmps;
		this.listOfEmps = listOfEmps;
		this.comp = comp;
	}
	
	
}
