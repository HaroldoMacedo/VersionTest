package com.versioning.sample.map;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMapper;
import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.EmployeeV3;
import com.versioning.sample.entity.PersonV1;
import com.versioning.sample.util.HttpMethodsCall;

public class EmployeeMap_V3V2 implements EntityVersionMapper {

  /**
   * Map V3 to V2.
   */
  @Override
  public Entity map(Entity entity) {
    EmployeeV3 employeeFrom = (EmployeeV3)entity;
    EmployeeV2 employeeTo = new EmployeeV2();

    BeanUtils.copyProperties(employeeFrom, employeeTo);

    try {
      //  Call to the GET /persons/{id} to obtain V2 first name and last name.
      ResponseEntity<?> re = HttpMethodsCall.get(((EmployeeV3)entity).getPerson(), 1, PersonV1.class);
      PersonV1 person = (PersonV1)re.getBody();
      employeeTo.setFirstName(person.getFirstName());
      employeeTo.setLastName(person.getLastName());
    } catch (HttpClientErrorException hce) {
      // In this case, don't return name.
    }

    return employeeTo;
  }
}
