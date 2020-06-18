package com.versioning.sample.map;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMapper;
import com.versioning.map.EntityVersionMap;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.entity.IdV2;

public class IdMap_V2V1 implements EntityVersionMapper {

  public IdMap_V2V1() {
  }

  @Override
  @EntityVersionMap(entityName = "Id", fromVersion = 2, toVersion = 1)
  public Entity map(Entity entity) {
    IdV2 idFrom = (IdV2)entity;

    IdV1 idTo = new IdV1(Integer.parseInt(idFrom.getId())); 

    return idTo;
  }
}
