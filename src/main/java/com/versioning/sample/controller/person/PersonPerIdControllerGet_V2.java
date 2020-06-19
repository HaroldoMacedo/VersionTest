package com.versioning.sample.controller.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.versioning.VersionExecuter;
import com.versioning.VersioningConfigurationException;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.entity.PersonV2;
import com.versioning.sample.factories.PersonPerIdModelFactory;
import com.versioning.util.Method;

@RestController
public class PersonPerIdControllerGet_V2 {

  private VersionExecuter executer;
  PersonPerIdControllerGet_V2() throws VersioningConfigurationException {
    executer = PersonPerIdModelFactory.getExecuterForMethodVersion(Method.GET, 2);
  }
  
  /**
   * GET /persons/{personId} V2
   * 
   * @param personId
   * @return
   * @throws VersioningConfigurationException 
   */
  @GetMapping(path = "/persons/{personId}", produces = "application/vnd.si.v2+json")
  public @ResponseBody PersonV2 getPersonPerIdV2(@PathVariable(name = "personId") int personId) throws VersioningConfigurationException {
    return (PersonV2)executer.execute(new IdV2(personId + ""), PersonV2.class);
  }
}
