package com.versioning.sample.model.mock;

import com.versioning.entity.Entity;
import com.versioning.model.ExecuteVersion;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.IdV1;

public class GetEmployeePerIdMockV1 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Id", inputVersion=1, outputEntity="Employee", outputVersion=1)
  public Entity execute(Entity entity) {
    IdV1 id = (IdV1)entity;
    EmployeeV1 employee = new EmployeeV1(id.getId());
    employee.setFullName("Haroldo Macedo");
    employee.setEmail("email@email.com");
    employee.setPhone("123457689");

    return employee;
  }
  

}
