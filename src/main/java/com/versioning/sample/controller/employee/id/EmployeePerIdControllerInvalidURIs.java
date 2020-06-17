package com.versioning.sample.controller.employee.id;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.sample.entity.ErrorV1;

@RestController
public class EmployeePerIdControllerInvalidURIs {

  /**
   * GET
   * Validates all other Accept parameters as error request.
   * 
   * @param employeeId
   * @return
   */
  @GetMapping(path = "/employees/{employeeId}", produces = {"application/json"})
  @ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public @ResponseBody ErrorV1 getEmployeePerIdNotAccepted(@PathVariable(name = "employeeId") int employeeId) {
    return new ErrorV1(1, "No or wrong Accept header parameter. Or, Error in the URL.");
  }

  /**
   * DELETE
   * Validates all other Accept parameters as error request.
   * 
   * @param newEmployee
   * @return
   */
  @DeleteMapping(path = "/employees/{employeeId}", produces = {"application/json"})
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public @ResponseBody ErrorV1 deleteEmployeePerIdNotAccepted(@PathVariable(name = "employeeId") int employeeId) {
    return new ErrorV1(1, "No or wrong Accept header parameter. Or, Error in the URL.");
  }
}
