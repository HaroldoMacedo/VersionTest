package com.versioning.test.employee.v3;

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

import com.versioning.sample.entity.EmployeeV3;
import com.versioning.sample.entity.ErrorV1;

@SpringBootTest
class TestEmployeeV3_Get {

	private static final String BASE_URL = "http://localhost:8080/employees/";
	private HttpHeaders headersContentType = new HttpHeaders();
	private HttpHeaders headersNone = new HttpHeaders();
	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Initialization.
	 */
	private TestEmployeeV3_Get() {
		MediaType mt = new MediaType("application", "vnd.si.v3+json");
		headersContentType.setAccept(Arrays.asList(mt));
	}

	/**
	 * Test V3 OK
	 */
	@Test
	public void getEmployee_Ok() {
	  String id = "12345";
		String url = BASE_URL + id;
		ResponseEntity<EmployeeV3> response = null;

		//	Request with Content-Type Header
		response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headersContentType), EmployeeV3.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(id, response.getBody().getId());
	}

  /**
   * Test NOK
   */
	@Test
	public void getEmployee_Nok() {
    String id = "12345";
    String url = BASE_URL + id;

		// Request with no Content-Type Header
		try {
			restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headersNone), ErrorV1.class);
			assertFalse(true);
		} catch (HttpClientErrorException he) {
			assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, he.getStatusCode());
		}
	}
}

