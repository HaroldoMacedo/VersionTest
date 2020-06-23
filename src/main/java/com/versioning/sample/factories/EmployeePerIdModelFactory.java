package com.versioning.sample.factories;

import com.versioning.VersionConfigure;
import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.map.EmployeeMap_V1V2;
import com.versioning.sample.map.EmployeeMap_V2V1;
import com.versioning.sample.map.EmployeeMap_V2V3;
import com.versioning.sample.map.EmployeeMap_V3V2;
import com.versioning.sample.map.IdMap_V1V2;
import com.versioning.sample.map.IdMap_V2V1;
import com.versioning.sample.model.mock.DeleteEmployeePerIdMockV2;
import com.versioning.sample.model.mock.GetEmployeePerIdMockV3;
import com.versioning.util.Method;

public class EmployeePerIdModelFactory  {

  static {
    VersionConfigure.registerMappers(new EmployeeMap_V1V2(), new EmployeeMap_V2V1(), new EmployeeMap_V2V3(), new EmployeeMap_V3V2(),
                                    new IdMap_V1V2(), new IdMap_V2V1());
  }
  
  /**
   * Returns the class that runs a method operation (POST, PUT, GET) for a
   * specific request version.
   * 
   * @param method  - POST, PUT, GET etc
   * @param version - The version number of the request.
   * @return - Class that can run this version request.
   * @throws VersioningConfigurationException
   */
  public static VersionExecuter getExecuterForMethodVersion(Method method, int version) throws VersioningConfigurationException {
    switch (method) {
      case GET:
        switch (version) {
          case 1:
//            return VersionConfigure.get(new GetEmployeePerIdMockV1());
          case 2:
//            return VersionConfigure.get(new GetEmployeePerIdMockV2());
          case 3:
            return VersionConfigure.get(new GetEmployeePerIdMockV3());
        }
        break;
  
      case DELETE:
        switch (version) {
          case 1:
//            return VersionConfigure.get(new DeleteEmployeePerIdV1());
          case 2:
            return VersionConfigure.get(new DeleteEmployeePerIdMockV2());
        }
      default:
        throw new RuntimeException("Method " + method + " is not implemented for EmployeeModel class");
    }
    throw new RuntimeException("Version " + version + " does not exist for EmployeeModel class");
  }
}
