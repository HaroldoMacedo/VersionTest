package com.versioning.test.employee.v2;

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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.versioning.sample.entity.EmployeeV2;

@SpringBootTest
class TestEmployeeV2_Delete {

	private static final String BASE_URL = "http://localhost:8080/employees/";
  private static MediaType mt = new MediaType("application", "vnd.si.v2+json");
  
	private HttpHeaders headersContentType = new HttpHeaders();
	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Initialization.
	 */
	public TestEmployeeV2_Delete() {
		headersContentType.setAccept(Arrays.asList(mt));
	}

	/**
	 * Test V2 - GONE
	 */
	@Test
	public void deleteEmployee_Ok() {
	  int id = 112233;
		String url = BASE_URL + id;
		
		//	Request with Content-Type Header
    try {
      restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headersContentType), EmployeeV2.class);
      assertFalse(true);
    } catch (HttpClientErrorException he) {
      assertEquals(HttpStatus.GONE, he.getStatusCode());
    }
	}

}

