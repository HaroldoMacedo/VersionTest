package com.versioning.sample.factories;

import com.versioning.VersionConfigure;
import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.map.EmployeeMap_V1V2;
import com.versioning.sample.map.EmployeeMap_V2V1;
import com.versioning.sample.map.IdMap_V1V2;
import com.versioning.sample.map.IdMap_V2V1;
import com.versioning.sample.model.mock.DeleteEmployeePerIdV1;
import com.versioning.sample.model.mock.DeleteEmployeePerIdV2;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV1;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV2;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV3;
import com.versioning.util.Method;

public class EmployeePerIdModelFactory  {

  static {
    VersionConfigure.registerMappers(new EmployeeMap_V1V2(), new EmployeeMap_V2V1(), new IdMap_V1V2(), new IdMap_V2V1());
  }
  
  public static VersionExecuter getExecuterForMethodVersion(Method method, int version) throws VersioningConfigurationException {
    switch (method) {
      case GET:
        switch (version) {
          case 1:
            return VersionExecuter.get(new GetEmployeePerIdMockV1());
          case 2:
            return VersionExecuter.get(new GetEmployeePerIdMockV2());
          case 3:
            return VersionExecuter.get(new GetEmployeePerIdMockV3());
        }
        break;
  
      case DELETE:
        switch (version) {
          case 1:
            return VersionExecuter.get(new DeleteEmployeePerIdV1());
          case 2:
            return VersionExecuter.get(new DeleteEmployeePerIdV2());
        }
      default:
        throw new RuntimeException("Method " + method + " is not implemented for EmployeeModel class");
    }
    throw new RuntimeException("Version " + version + " does not exist for EmployeeModel class");
  }
}
