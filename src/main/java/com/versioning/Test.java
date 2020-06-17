package com.versioning;

import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

public class Test {

  // TODO: Remove this main method.
  public static void main(String[] args) throws VersioningConfigurationException {
    // Mocking a GET /employee/{id} factory
//    VersionOperationWrapper mve = EmployeePerIdModelFactory.getModelForMethodVersion(Method.GET, 1); 
    VersionExecuter mve = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2); 
    EmployeeV1 employee = (EmployeeV1)mve.execute(new IdV1(10), EmployeeV1.class);
    System.out.println("Employee name = '" + employee.getFullName() + "'");

//    VersionOperationWrapper mve = EmployeePerIdModelFactory.getModelForMethodVersion(Method.GET, 2); 
//    VersionOperationWrapper mve = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2); 
//    EmployeeV2 employee = (EmployeeV2)mve.execute(new IdV2("5"), EmployeeV2.class);
//    System.out.println("Employee name = '" + employee.getFirstName() + "'");
  }

}

