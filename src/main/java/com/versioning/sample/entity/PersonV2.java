package com.versioning.sample.entity;

import com.versioning.entity.Entity;
import com.versioning.entity.EntityVersion;

@EntityVersion(name = "Person", version = 2)
public class PersonV2 implements Entity {

  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private int status;

  public PersonV2() {
  }

  public PersonV2(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
