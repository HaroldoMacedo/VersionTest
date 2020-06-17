package com.versioning.sample.map;

import org.springframework.beans.BeanUtils;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMapper;
import com.versioning.map.EntityVersion;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.EmployeeV2;

public class EmployeeMap_V2V1 implements EntityVersionMapper {

  @Override
  @EntityVersion(entityName = "Employee", fromVersion = 2, toVersion = 1)
  public Entity map(Entity entity) {
    EmployeeV2 employeeFrom = (EmployeeV2) entity;
    EmployeeV1 employeeTo = new EmployeeV1(Integer.parseInt(employeeFrom.getId()));

    BeanUtils.copyProperties(employeeFrom, employeeTo);
    employeeTo.setFullName(employeeFrom.getFirstName() + " " + employeeFrom.getLastName());

    return employeeTo;
  }
}
