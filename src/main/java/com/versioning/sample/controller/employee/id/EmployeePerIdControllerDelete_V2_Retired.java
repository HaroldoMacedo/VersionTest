package com.versioning.sample.controller.employee.id;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.sample.entity.EmployeeV1;

@RestController
public class EmployeePerIdControllerDelete_V2_Retired {

  /**
   * DELETE /employees/{employeeId}
   * V2 - RETIRED!
   *  
   * @param newEmployee
   * @return
   * 
   * @apiNote Use <B>case A</B> - Remove of an operation.<BR>
   *          Method DELETE is not present. 
   *          Solution 2 - Return HTTP Code
   */
  @DeleteMapping(path = "/employees/{employeeId}", produces = "application/vnd.si.v2+json")
  @ResponseStatus(HttpStatus.GONE)
  public @ResponseBody EmployeeV1 deleteEmployeeV2(@PathVariable(name = "employeeId") int employeeId) {
    return null;
  }
}
