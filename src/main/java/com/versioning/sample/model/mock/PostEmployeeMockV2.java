package com.versioning.sample.model.mock;

import com.versioning.VersioningConfigurationException;
import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;

public class PostEmployeeMockV2 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Employee", inputVersion=2, outputEntity="Id", outputVersion=2)
  public Entity execute(Entity entity) throws VersioningConfigurationException {
    EmployeeV2 employee = (EmployeeV2)entity;
    
    return new IdV2(employee.getId());
  }

}
