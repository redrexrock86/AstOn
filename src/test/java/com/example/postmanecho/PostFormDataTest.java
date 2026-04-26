package com.example.postmanecho;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

class PostFormDataTest extends PostmanEchoBaseTest {

  @Test
  void postFormData_shouldReturn200_andExpectedBody() throws Exception {
    String path = "/post";
    Map<String, String> form = new LinkedHashMap<>();
    form.put("foo1", "bar1");
    form.put("foo2", "bar2");

    Response response = given()
        .baseUri(BASE_URL)
        .accept(ContentType.JSON)
        .header("x-test-header", "hello")
        // Явно задаём form-urlencoded как в Postman, чтобы сервер стабильно понимал запрос.
        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
        .urlEncodingEnabled(true)
        .formParams(form)
        .when()
        .post(path)
        .then()
        .extract()
        .response();

    assertEchoResponse(
        response,
        200,
        BASE_URL + path,
        Map.of(),
        "",
        form,
        form,
        Map.of(
            "x-test-header", "hello",
            "host", "postman-echo.com"
        )
    );
  }
}

