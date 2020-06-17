package com.versioning.sample.controller.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.factories.EmployeeModelFactory;
import com.versioning.util.Method;

@RestController
public class EmployeeControllerPost_V2 {

  private VersionExecuter executer;

  EmployeeControllerPost_V2() throws VersioningConfigurationException {
    executer = EmployeeModelFactory.getExecuterForMethodVersion(Method.POST, 2);
  }

  /**
   * POST /employees V2
   * 
   * @param newEmployee
   * @return
   * @throws VersioningConfigurationException
   */
  @PostMapping(path = "/employees", consumes = "application/vnd.si.v2+json")
  @ResponseStatus(HttpStatus.CREATED) // 201
  public @ResponseBody IdV2 postEmployeeV2(@RequestBody EmployeeV2 newEmployee) throws VersioningConfigurationException {
    return (IdV2) executer.execute(newEmployee, IdV2.class);
  }
}