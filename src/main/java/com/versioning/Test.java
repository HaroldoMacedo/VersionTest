package com.versioning;

import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

public class Test {

  // TODO: Remove this main method.
  public static void main(String[] args) throws VersioningConfigurationException {
    // Mocking a GET /employee/{id} factory
//    VersionOperationWrapper mve = EmployeePerIdModelFactory.getModelForMethodVersion(Method.GET, 1); 
//    VersionExecuter mve = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2); 
//    EmployeeV1 employee = (EmployeeV1)mve.execute(new IdV1(10), EmployeeV1.class);
//    System.out.println("Employee name = '" + employee.getFullName() + "'");

    VersionExecuter mve = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2); 
    EmployeeV2 employee = (EmployeeV2)mve.execute(new IdV2("5"), EmployeeV2.class);
    System.out.println("Employee name = '" + employee.getFirstName() + "'");
  }

//  public static void main(String[] args) throws Exception{
//    System.out.println("Starting...");
//    EmployeeMap_V1V2 employeeMap = new EmployeeMap_V1V2();
//
//    System.out.println("Calling map");
//    EmployeeV1 employee = new EmployeeV1(1);
//    employee.setFullName("Haroldo Macedo");
//    employeeMap.map(employee);
//    System.out.println("Mapped!\n\n");
//  }

//  public static void main(String[] args) {
//    System.out.println("Starting...");
//    GetEmployeePerIdMockV1 runGetEmployee = new GetEmployeePerIdMockV1();
//
//    System.out.println("Calling map");
//    runGetEmployee.execute(new IdV1(1));
//    System.out.println("Mapped!\n\n");
//  }

//  public static void main(String[] args) {
//    System.out.println("Starting...");
//    GetPersonPerIdMockV1 runGetEmployee = new GetPersonPerIdMockV1();
//
//    System.out.println("Calling map");
//    runGetEmployee.execute(new IdV1(1));
//    System.out.println("Mapped!\n\n");
//  }
  
//  public static void main(String[] args) {
//    System.out.println("Starting...");
//    GetPersonPerIdMockV2 runGetEmployee = new GetPersonPerIdMockV2();
//
//    System.out.println("Calling map");
//    runGetEmployee.execute(new IdV1(1));
//    System.out.println("Mapped!\n\n");
//  }

}

