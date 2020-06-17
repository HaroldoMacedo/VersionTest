package com.versioning.sample.factories;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.model.mock.PostEmployeeMockV1;
import com.versioning.sample.model.mock.PostEmployeeMockV2;
import com.versioning.sample.model.mock.PostEmployeeMockV3;
import com.versioning.util.Method;

public class EmployeeModelFactory {

  public static VersionExecuter getExecuterForMethodVersion(Method method, int version) throws VersioningConfigurationException {
    switch (method) {
      case POST:
        switch (version) {
          case 1:
            return VersionExecuter.get(new PostEmployeeMockV1());
          case 2:
            return VersionExecuter.get(new PostEmployeeMockV2());
          case 3:
            return VersionExecuter.get(new PostEmployeeMockV3());
        }
        break;
  
      default:
        throw new RuntimeException("Method " + method + " is not implemented for EmployeeModel class");
    }
    throw new RuntimeException("Version " + version + " does not exist for EmployeeModel class");
  }
}
