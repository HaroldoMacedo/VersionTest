package com.versioning.sample.model.mock;

import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;

public class GetEmployeePerIdMockV2 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Id", inputVersion=2, outputEntity="Employee", outputVersion=2)
  public Entity execute(Entity entity) {
    IdV2 id = (IdV2)entity;
    EmployeeV2 employee = new EmployeeV2(id.getId());
    employee.setFirstName("Haroldo");
    employee.setLastName("Macedo");
    employee.setEmail("email@email.com");
    employee.setPhone("123457689");

    return employee;
  }
}
