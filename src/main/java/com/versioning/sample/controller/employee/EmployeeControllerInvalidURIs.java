package com.versioning.sample.controller.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.ErrorV1;

@RestController
public class EmployeeControllerInvalidURIs {

  /**
   * POST
   * Validates all other Accept parameters as error request.
   * 
   * @param newEmployee
   * @return
   */
  @PostMapping(path = "/employees")
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public @ResponseBody ErrorV1 postEmployeeNotAccepted(@RequestBody EmployeeV1 newEmployee) {
    return new ErrorV1(1, "No or wrong Accept header parameter. Or, Error in the URL.");
  }
}
