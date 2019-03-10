package com.em.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "table_companys")
public class CompanyDto {


	@Id
	@GenericGenerator(name = "gen" , strategy = "increment")
	@GeneratedValue(generator ="gen")
	private Long id;
	
	@Column(name = "cmp_name" ,nullable = false)
	private String name ;
	
	@Embedded
	private AddressDto address;
	
	@OneToMany(mappedBy = "comp" ,cascade  = CascadeType.ALL)
	private List<DepartmentDto> listOfDepts = new ArrayList<DepartmentDto>();
	
	@OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
	private List<EmployeeDto> listOfEmps = new ArrayList<EmployeeDto>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public List<DepartmentDto> getListOfDepts() {
		return listOfDepts;
	}

	public void setListOfDepts(List<DepartmentDto> listOfDepts) {
		this.listOfDepts = listOfDepts;
	}

	public List<EmployeeDto> getListOfEmps() {
		return listOfEmps;
	}

	public void setListOfEmps(List<EmployeeDto> listOfEmps) {
		this.listOfEmps = listOfEmps;
	}

	public CompanyDto(String name, AddressDto address, List<DepartmentDto> listOfDepts,
			List<EmployeeDto> listOfEmps) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.listOfDepts = listOfDepts;
		this.listOfEmps = listOfEmps;
	}

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
