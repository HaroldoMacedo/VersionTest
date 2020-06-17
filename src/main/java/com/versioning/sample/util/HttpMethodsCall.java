package com.versioning.sample.util;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Emulate a GET method.
 * 
 * @author Haroldo Macêdo
 *
 */
public class HttpMethodsCall {
  private static final String BASE_URL = "http://localhost:8080";

  /**
   * GET method
   * 
   * @param uri
   * @param version
   * @param classe
   * @return
   */
  public static ResponseEntity<?> get(String uri, int version, Class<?> classe) {
    String url = BASE_URL + uri;
    MediaType mt = new MediaType("application", "vnd.si.v" + version + "+json");
    HttpHeaders headersContentType = new HttpHeaders();
    headersContentType.setAccept(Arrays.asList(mt));
    ResponseEntity<?> response = null;

    //  Request with Content-Type Header
    RestTemplate restTemplate = new RestTemplate();
    response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headersContentType), classe);

    return response;
  }
  
}
