package com.versioning.sample.map;

import org.springframework.beans.BeanUtils;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMap;
import com.versioning.map.EntityVersionMapper;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.EmployeeV3;

public class EmployeeMap_V2V3 implements EntityVersionMapper {

  @Override
  @EntityVersionMap(entityName = "Employee", fromVersion = 2, toVersion = 3)
  public Entity map(Entity entity) {
    EmployeeV2 employeeFrom = (EmployeeV2)entity;
    EmployeeV3 employeeTo = new EmployeeV3();

    BeanUtils.copyProperties(employeeFrom, employeeTo);
    employeeTo.setPerson("/persons/1234");

    return employeeTo;
  }
}
