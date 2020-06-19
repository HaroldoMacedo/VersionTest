package com.versioning.sample.map;


import org.springframework.beans.BeanUtils;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMapper;
import com.versioning.map.EntityVersionMap;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.EmployeeV2;

public class EmployeeMap_V1V2 implements EntityVersionMapper {

  @Override
  @EntityVersionMap(entityName = "Employee", fromVersion = 1, toVersion = 2)
  public Entity map(Entity entity) {
    EmployeeV1 employeeFrom = (EmployeeV1) entity;
    EmployeeV2 employeeTo = new EmployeeV2();

    BeanUtils.copyProperties(employeeFrom, employeeTo);
    employeeTo.setId(employeeFrom.getId() + "");
    employeeTo.setFirstName(firstName(employeeFrom.getFullName()));
    employeeTo.setLastName(lastName(employeeFrom.getFullName()));

    return employeeTo;
  }


  /**
   * Implements the approved way to transform a full name into a first name.
   * 
   * @param fullName
   * @return
   */
  private String firstName(String fullName) {
    return fullName.substring(0, 5);
  }

  /**
   * Implements the approved way to transform a full name into a last name.
   * 
   * @param fullName
   * @return
   */
  private String lastName(String fullName) {
    return fullName.substring(5);
  }

}
