package com.versioning.sample.controller.employee.id;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

@RestController
public class EmployeePerIdControllerGet_V2 {

  private VersionExecuter executer;
  EmployeePerIdControllerGet_V2() throws VersioningConfigurationException {
    executer = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2);
  }

  /**
   * GET /employees/{employeeId} V2
   * 
   * @param employeeId
   * @return
   * @throws VersioningConfigurationException 
   */
  @GetMapping(path = "/employees/{employeeId}", produces = "application/vnd.si.v2+json")
  public @ResponseBody EmployeeV2 getEmployeePerIdV2(@PathVariable(name = "employeeId") String employeeId) throws VersioningConfigurationException {
    return (EmployeeV2)executer.execute(new IdV2(employeeId), EmployeeV2.class);
  }
}
