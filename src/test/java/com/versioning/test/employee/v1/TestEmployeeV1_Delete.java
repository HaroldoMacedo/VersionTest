package com.versioning.test.employee.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

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

import com.versioning.sample.entity.EmployeeV1;
import com.versioning.sample.entity.ErrorV1;

@SpringBootTest
class TestEmployeeV1_Delete {

	private static final String BASE_URL = "http://localhost:8080/employees/";
  private static MediaType mt = new MediaType("application", "vnd.si.v1+json");
  
	private HttpHeaders headersContentType = new HttpHeaders();
	private HttpHeaders headersNone = new HttpHeaders();
	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Initialization.
	 */
	public TestEmployeeV1_Delete() {
		headersContentType.setAccept(Arrays.asList(mt));
	}

	/**
	 * Test V1 OK
	 */
	@Test
	public void deleteEmployee_Ok() {
	  int id = 112233;
		String url = BASE_URL + id;
		ResponseEntity<EmployeeV1> response = null;
		
		//	Request with Content-Type Header
		response = restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headersContentType), EmployeeV1.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(id, response.getBody().getId());
	}

  /**
   * Test NOK
   */
	@Test
	public void deleteEmployee_Nok() {
    int id = 12345;
    String url = BASE_URL + id;
    
		// Request with no Content-Type Header
		try {
			restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headersNone), ErrorV1.class);
			assertFalse(true);
		} catch (HttpClientErrorException he) {
			assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, he.getStatusCode());
		}
	}
}

