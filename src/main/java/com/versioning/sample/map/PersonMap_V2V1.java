package com.versioning.sample.map;


import org.springframework.beans.BeanUtils;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMap;
import com.versioning.map.EntityVersionMapper;
import com.versioning.sample.entity.PersonV1;
import com.versioning.sample.entity.PersonV2;

public class PersonMap_V2V1 implements EntityVersionMapper {

  @Override
  @EntityVersionMap(entityName = "Person", fromVersion = 2, toVersion = 1)
  public Entity map(Entity entity) {
    PersonV2 personFrom = (PersonV2) entity;
    PersonV1 personTo = new PersonV1();

    BeanUtils.copyProperties(personFrom, personTo);
    personTo.setId(Integer.parseInt(personFrom.getId()));

    return personTo;
  }
}
