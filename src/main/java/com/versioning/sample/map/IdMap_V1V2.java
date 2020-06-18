package com.versioning.sample.map;

import com.versioning.entity.Entity;
import com.versioning.map.EntityVersionMapper;
import com.versioning.map.EntityVersionMap;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.entity.IdV2;

public class IdMap_V1V2 implements EntityVersionMapper {

  public IdMap_V1V2() {
  }

  @Override
  @EntityVersionMap(entityName = "Id", fromVersion = 1, toVersion = 2)
  public Entity map(Entity entity) {
    IdV1 idFrom = (IdV1)entity;

    IdV2 idTo = new IdV2(idFrom.getId() + ""); 

    return idTo;
  }
}
