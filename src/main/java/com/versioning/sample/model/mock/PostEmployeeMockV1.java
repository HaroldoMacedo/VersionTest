package com.versioning.sample.model.mock;

import com.versioning.VersioningConfigurationException;
import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.IdV1;

public class PostEmployeeMockV1 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Employee", inputVersion=1, outputEntity="Id", outputVersion=1)
  public Entity execute(Entity entity) throws VersioningConfigurationException {
    EmployeeV1 employee = (EmployeeV1)entity;
    
    return new IdV1(employee.getId());
  }

}
