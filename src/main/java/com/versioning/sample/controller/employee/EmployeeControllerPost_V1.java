package com.versioning.sample.controller.employee;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.entity.Entity;
import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.ErrorV1;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.factories.EmployeeModelFactory;
import com.versioning.util.Method;

@RestController
public class EmployeeControllerPost_V1 {

  private VersionExecuter executer;
  EmployeeControllerPost_V1() throws VersioningConfigurationException {
    executer = EmployeeModelFactory.getExecuterForMethodVersion(Method.POST, 1);
  }

  /**
   * POST /employees V1
   * 
   * @param newEmployee
   * @return
   * @throws VersioningConfigurationException 
   */
  @PostMapping(path = "/employees", consumes = "application/vnd.si.v1+json")
  @ResponseStatus(HttpStatus.CREATED) // 201
  public @ResponseBody Entity postEmployeeV1(@Valid @RequestBody EmployeeV1 newEmployee, BindingResult result) throws VersioningConfigurationException {
    if(result.hasErrors())
      return new ErrorV1(1, "Error");

    return (IdV1)executer.execute(newEmployee, IdV1.class);
  }
}