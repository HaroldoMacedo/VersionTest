package com.versioning.sample.entity;

import com.versioning.entity.Entity;
import com.versioning.entity.EntityVersion;

/**
 * Id to be returned by POST and PUT methods.
 * 
 * @author Haroldo Mac�do
 *
 */
@EntityVersion(name = "Id", version = 1)
public class IdV1 implements Entity {

  private int id;

  public IdV1() {}

  public IdV1(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
