package com.em.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "table_posts")
public class PostDto {
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;
	@Column(name = "post_contents")
	private String postContents;
	@Column(name = "post_author")
	private String authorName;
	@Column(name = "post_author_company")
	private String authorCompany;
	@Column(name = "post_color")
	private String postColor;

	public String getPostColor() {
		return postColor;
	}

	public void setPostColor(String postColor) {
		this.postColor = postColor;
	}

	@ManyToOne
	@JoinColumn(name = "emp_id")
	EmployeeDto postEmp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorCompany() {
		return authorCompany;
	}

	public void setAuthorCompany(String authorCompany) {
		this.authorCompany = authorCompany;
	}

	public EmployeeDto getPostEmp() {
		return postEmp;
	}

	public void setPostEmp(EmployeeDto postEmp) {
		this.postEmp = postEmp;
	}

	public PostDto() {
		// TODO Auto-generated constructor stub
	}

	public PostDto(long id, String postContents, String authorName, String authorCompany, EmployeeDto postEmp) {
		super();
		this.id = id;
		this.postContents = postContents;
		this.authorName = authorName;
		this.authorCompany = authorCompany;
		this.postEmp = postEmp;
	}
	
	

}
