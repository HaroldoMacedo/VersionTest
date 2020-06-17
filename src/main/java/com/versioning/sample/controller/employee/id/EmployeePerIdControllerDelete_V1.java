package com.versioning.sample.controller.employee.id;

import org.springframework.web.bind.annotation.DeleteMapping;
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
public class EmployeePerIdControllerDelete_V1 {

  private VersionExecuter executer;
  EmployeePerIdControllerDelete_V1() throws VersioningConfigurationException {
    executer = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.DELETE, 1);
  }
  

  /**
   * DELETE /employees/{employeeId} V1
   * 
   * @deprecated
   * 
   * @param newEmployee
   * @return
   * @throws VersioningConfigurationException 
   */
  @DeleteMapping(path = "/employees/{employeeId}", produces = "application/vnd.si.v1+json")
  public @ResponseBody EmployeeV1 deleteEmployeeV1(@PathVariable(name = "employeeId") int employeeId) throws VersioningConfigurationException {
    return (EmployeeV1) executer.execute(new IdV1(employeeId), EmployeeV1.class);
  }
}
