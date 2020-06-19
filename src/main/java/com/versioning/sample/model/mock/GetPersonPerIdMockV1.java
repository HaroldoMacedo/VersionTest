package com.versioning.sample.model.mock;

import com.versioning.entity.Entity;
import com.versioning.model.ExecuteOperationVersion;
import com.versioning.model.ExecuteVersion;
import com.versioning.sample.entity.IdV1;
import com.versioning.sample.entity.PersonV1;

public class GetPersonPerIdMockV1 implements ExecuteOperationVersion {

  @Override
  @ExecuteVersion(inputEntity="Id", inputVersion=1, outputEntity="Person", outputVersion=1)
  public Entity execute(Entity entity) {
    IdV1 id = (IdV1)entity;
    PersonV1 person = new PersonV1(id.getId());
    person.setFirstName("Haroldo");
    person.setLastName("Macedo");
    person.setEmail("email@email.com");
    person.setPhone("123457689");

    return person;
  }
}
