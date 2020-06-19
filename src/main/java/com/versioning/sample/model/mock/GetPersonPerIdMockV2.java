package com.versioning.sample.model.mock;

import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.IdV2;
import com.versioning.sample.entity.PersonV2;

public class GetPersonPerIdMockV2 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Id", inputVersion=2, outputEntity="Person", outputVersion=2)
  public Entity execute(Entity entity) {
    IdV2 id = (IdV2)entity;
    PersonV2 person = new PersonV2(id.getId());
    person.setFirstName("Haroldo");
    person.setLastName("Macedo");
    person.setEmail("email@email.com");
    person.setPhone("123457689");

    return person;
  }
}
