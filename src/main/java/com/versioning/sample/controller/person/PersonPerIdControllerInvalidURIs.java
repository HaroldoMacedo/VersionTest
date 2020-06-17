package com.versioning.sample.controller.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.sample.entity.ErrorV1;

@RestController
public class PersonPerIdControllerInvalidURIs {

  /**
   * Validates all other Accept parameters as error request.
   * 
   * @param personId
   * @return
   */
  @GetMapping(path = "/persons/{personId}", produces = {"application/json"})
  @ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public @ResponseBody ErrorV1 getPersonPerIdNotAccepted(@PathVariable(name = "personId") int personId) {
    return new ErrorV1(1, "No or wrong Accept header parameter. Or, Error in the URL.");
  }
}
