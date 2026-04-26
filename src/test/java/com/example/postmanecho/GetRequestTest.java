package com.example.postmanecho;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

class GetRequestTest extends PostmanEchoBaseTest {

  @Test
  void get_shouldReturn200_andExpectedBody() throws Exception {
    String path = "/get";
    Map<String, String> query = new LinkedHashMap<>();
    query.put("foo1", "bar1");
    query.put("foo2", "bar2");

    Response response = given()
        .baseUri(BASE_URL)
        .accept(ContentType.JSON)
        .header("x-test-header", "hello")
        .queryParams(query)
        .when()
        .get(path)
        .then()
        .extract()
        .response();

    String expectedUrl = BASE_URL + path + "?foo1=bar1&foo2=bar2";

    assertEchoResponse(
        response,
        200,
        expectedUrl,
        query,
        "",
        null,
        Map.of(),
        Map.of(
            "x-test-header", "hello",
            "host", "postman-echo.com"
        )
    );
  }
}

