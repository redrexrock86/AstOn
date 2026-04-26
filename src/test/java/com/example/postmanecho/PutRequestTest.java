package com.example.postmanecho;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

class PutRequestTest extends PostmanEchoBaseTest {

  @Test
  void putRawText_shouldReturn200_andExpectedBody() throws Exception {
    String path = "/put";
    String data = "This is expected to be sent back as part of response body.";

    Response response = given()
        .baseUri(BASE_URL)
        .accept(ContentType.JSON)
        .header("x-test-header", "hello")
        .body(data)
        .when()
        .put(path)
        .then()
        .extract()
        .response();

    assertEchoResponse(
        response,
        200,
        BASE_URL + path,
        Map.of(),
        data,
        null,
        Map.of(),
        Map.of(
            "x-test-header", "hello",
            "host", "postman-echo.com"
        )
    );
  }
}

