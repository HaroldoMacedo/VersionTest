package com.versioning.sample.controller.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.entity.PersonV1;
import com.versioning.sample.factories.EmployeePerIdModelFactory;
import com.versioning.util.Method;

@RestController
public class PersonPerIdControllerGet_V1 {

  private VersionExecuter executer;
  PersonPerIdControllerGet_V1() throws VersioningConfigurationException {
    executer = EmployeePerIdModelFactory.getExecuterForMethodVersion(Method.GET, 1);
  }
  
  /**
   * GET /persons/{personId} V1
   * 
   * @param personId
   * @return
   * @throws VersioningConfigurationException 
   */
  @GetMapping(path = "/persons/{personId}", produces = "application/vnd.si.v1+json")
  public @ResponseBody PersonV1 getPersonPerIdV1(@PathVariable(name = "personId") String personId) throws VersioningConfigurationException {
    return (PersonV1)executer.execute(new IdV2(personId), PersonV1.class);
  }
}
