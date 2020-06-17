package com.versioning.sample.controller.employee.id;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

@RestController
public class EmployeePerIdControllerGet_V1 {

  private VersionExecuter executer;
  EmployeePerIdControllerGet_V1() throws VersioningConfigurationException {
    executer = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 1);
  }
  
  /**
   * GET /employees/{employeeId} V1
   * 
   * @param employeeId
   * @return
   */
  @GetMapping(path = "/employees/{employeeId}", produces = "application/vnd.si.v1+json")
  public @ResponseBody EmployeeV1 getEmployeePerIdV1(@PathVariable(name = "employeeId") int employeeId) throws VersioningConfigurationException {
      return (EmployeeV1)executer.execute(new IdV1(employeeId), EmployeeV1.class);
  }
}
