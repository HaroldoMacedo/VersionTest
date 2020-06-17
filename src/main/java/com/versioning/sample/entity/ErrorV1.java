package com.versioning.sample.entity;

import com.versioning.entity.Entity;
import com.versioning.entity.VersionEntity;

@VersionEntity(name="Error", version=1)
public class ErrorV1 implements Entity {

  private int code;
  private String description;

  public ErrorV1() {}

  public ErrorV1(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
