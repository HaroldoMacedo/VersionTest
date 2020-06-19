package com.versioning.sample.factories;

import com.versioning.VersionConfigure;
import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.model.mock.PostEmployeeMockV3;
import com.versioning.util.Method;

public class EmployeeModelFactory {

	/**
	 * Returns the class that runs a method operation (POST, PUT, GET) for a specific request version.
	 * 
	 * @param method - POST, PUT, GET etc
	 * @param version - The version number of the request.
	 * @return - Class that can run this version request.
	 * @throws VersioningConfigurationException
	 */
  public static VersionExecuter getExecuterForMethodVersion(Method method, int version) throws VersioningConfigurationException {
    switch (method) {
      case POST:
        switch (version) {
          case 1:
//            return VersionConfigure.get(new PostEmployeeMockV1());
          case 2:
//            return VersionConfigure.get(new PostEmployeeMockV2());
          case 3:
            return VersionConfigure.get(new PostEmployeeMockV3());
        }
        break;
  
      default:
        throw new RuntimeException("Method " + method + " is not implemented for EmployeeModel class");
    }
    throw new RuntimeException("Version " + version + " does not exist for EmployeeModel class");
  }
}
