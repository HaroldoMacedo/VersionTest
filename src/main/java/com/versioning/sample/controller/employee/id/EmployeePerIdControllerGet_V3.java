package com.versioning.sample.controller.employee.id;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.EmployeeV3;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

@RestController
public class EmployeePerIdControllerGet_V3 {

  private VersionExecuter executer;
  EmployeePerIdControllerGet_V3() throws VersioningConfigurationException {
    executer = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 3);
  }

  /**
   * GET /employees/{employeeId} V3
   * 
   * @param employeeId
   * @return
   * @throws VersioningConfigurationException 
   */
  @GetMapping(path = "/employees/{employeeId}", produces = "application/vnd.si.v3+json")
  public @ResponseBody EmployeeV3 getEmployeePerIdV2(@PathVariable(name = "employeeId") String employeeId) throws VersioningConfigurationException {
    return (EmployeeV3)executer.execute(new IdV2(employeeId), EmployeeV3.class);
  }
}
