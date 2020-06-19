package com.versioning.sample.model.mock;

import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.EmployeeV3;
import com.versioning.sample.entity.IdV2;

public class GetEmployeePerIdMockV3 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Id", inputVersion=2, outputEntity="Employee", outputVersion=3)
  public Entity execute(Entity entity) {
    IdV2 id = (IdV2)entity;
    EmployeeV3 employee = new EmployeeV3(id.getId());
    employee.setPerson("/persons/2222");
    employee.setEmail("email@email.com");
    employee.setPhone("123457689");
    employee.setSalaryStatement("/salaryStatement/654");

    return employee;
  }
}
