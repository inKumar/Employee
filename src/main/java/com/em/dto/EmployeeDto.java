package com.em.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "table_employees")
public class EmployeeDto {
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private Long id;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

//	@Column(name = "date_of_birth")
//	private Date dob;

//	@Column(name = "date_of_joining")
//	private Date dateOfJoing;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "login_id", nullable = false)
	private String loginId;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	private String role;

	@Embedded
	private AddressDto addressDto;
	
	
	
	
	

	@ManyToOne
	@JoinColumn(name = "dtp_id")
	private DepartmentDto department;

	@ManyToOne
	@JoinColumn(name = "comp_id")
	private CompanyDto company;
	
	
	@OneToMany(mappedBy = "postEmp" ,cascade  = CascadeType.ALL)
	private List<PostDto> listsOfposts = new ArrayList<PostDto>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//
//	public Date getDateOfJoing() {
//		return dateOfJoing;
//	}
//
//	public void setDateOfJoing(Date dateOfJoing) {
//		this.dateOfJoing = dateOfJoing;
//	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

//	@Override
//	public String toString() {
//		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
//				+ ", dateOfJoing=" + dateOfJoing + ", isActive=" + isActive + ", loginId=" + loginId + ", password="
//				+ password + ", role=" + role + ", addressDto=" + addressDto + ", department=" + department
//				+ ", company=" + company + "]";
//	}

	public EmployeeDto(Long id, String firstName, String lastName, Date dob, Date dateOfJoing, boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.dob = dob;
//		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}

	public EmployeeDto(String firstName, String lastName, Date dob, Date dateOfJoing, boolean isActive) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
//		this.dob = dob;
//		this.dateOfJoing = dateOfJoing;
		this.isActive = isActive;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<PostDto> getListsOfposts() {
		return listsOfposts;
	}

	public void setListsOfposts(List<PostDto> listsOfposts) {
		this.listsOfposts = listsOfposts;
	}
}
