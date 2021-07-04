package com.user;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "info about user")
@Entity
public class User {
	@NotNull
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name should have at least 2 chars")
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	private String name;
	
	//@Future
	@Past(message = "Please check if the date is in the past")
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthdate;
	
	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	

}
