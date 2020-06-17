package com.versioning.sample.entity;

import com.versioning.entity.Entity;
import com.versioning.entity.VersionEntity;

@VersionEntity(name = "Person", version = 1)
public class PersonV1 implements Entity {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private int status;

  public PersonV1() {
  }

  public PersonV1(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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
