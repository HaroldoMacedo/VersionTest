package com.versioning.sample.factories;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV1;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV2;
import com.versioning.util.Method;

public class PersonPerIdModelFactory {

  public static VersionExecuter getExecuterForMethodVersion(Method method, int version) throws VersioningConfigurationException {
    switch (method) {
      case GET:
        switch (version) {
          case 1:
            return VersionExecuter.get(new GetEmployeePerIdMockV1());
          case 2:
            return VersionExecuter.get(new GetEmployeePerIdMockV2());
        }
        break;

      default:
        throw new RuntimeException("Method " + method + " is not implemented for EmployeeModel class");
    }
    throw new RuntimeException("Version " + version + " does not exist for EmployeeModel class");
  }
}
