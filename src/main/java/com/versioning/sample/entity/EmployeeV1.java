package com.versioning.sample.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.versioning.entity.Entity;
import com.versioning.entity.EntityVersion;

@EntityVersion(name="Employee", version=1)
public class EmployeeV1 implements Entity {

  @Positive
	private int id;
  @NotEmpty
  @Size(max=20)
  @Pattern(regexp = "[A-Z][a-zA-Z0-9 ]*")
	private String fullName;
  @Email
	private String email;
	private String phone;
	private int	status;
	
  public EmployeeV1() {}

	public EmployeeV1(int id) {
	  this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
