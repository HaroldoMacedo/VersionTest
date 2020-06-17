package com.versioning.test.employee.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.versioning.sample.entity.EmployeeV2;
import com.versioning.sample.entity.IdV2;

@SpringBootTest
public class TestEmployeeV2_Post {
  private static final String BASE_URL = "http://localhost:8080/employees/";
  private HttpHeaders headersContentType = new HttpHeaders();
  private HttpHeaders headersNone = new HttpHeaders();
  private RestTemplate restTemplate = new RestTemplate();

  private TestEmployeeV2_Post() {
    headersContentType.setContentType(new MediaType("application", "vnd.si.v2+json"));
  }

  /**
   * Test OK
   */
  @Test
  public void postEmployee_Ok() {
    String id = "12345";
    String url = BASE_URL;
    ResponseEntity<IdV2> response = null;

    EmployeeV2 employee = createEmployee(id);

    // Request with Content Type Header
    response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(employee, headersContentType), IdV2.class);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(id, response.getBody().getId());
  }

  /**
   * Test NOK
   */
  @Test
  public void postEmployee_Nok() {
    String id = "12345";
    String url = BASE_URL;

    EmployeeV2 employee = createEmployee(id);

    // Request with no Content Type Header
    try {
      restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(employee, headersNone), Object.class);
      assertFalse(true);
    } catch (HttpClientErrorException he) {
      assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, he.getStatusCode());
    }
  }

  /**
   * Create a default employee.
   * @param id
   * @return
   */
  private EmployeeV2 createEmployee(String id) {
    EmployeeV2 employee = new EmployeeV2(id);
    employee.setFirstName("Haroldo");
    employee.setLastName("Macêdo");
    employee.setManager("Denis Lewis");
    employee.setEmail("email@email.com");
    employee.setPhone("123457689");
    employee.addTeamMember("Victor Almeida");
    employee.setSalaryStatement("/salaryStatement/654");

    return employee;
  }  
}
