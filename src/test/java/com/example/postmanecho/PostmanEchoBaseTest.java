package com.example.postmanecho;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

abstract class PostmanEchoBaseTest {
  protected static final String BASE_URL = "https://postman-echo.com";
  protected static final ObjectMapper MAPPER = new ObjectMapper();

  /**
   * В Postman Echo поле "headers" эхом возвращает все полученные заголовки.
   * Часть из них (например, proxy-* / accept-encoding / user-agent) может отличаться по среде,
   * поэтому для стабильных автотестов сравниваем все "бизнес-поля" ответа,
   * а в headers — только те ключи, которые мы сами задали + host.
   */
  protected static void assertEchoResponse(
      Response response,
      int expectedStatus,
      String expectedUrl,
      Map<String, ?> expectedArgs,
      String expectedData,
      Map<String, ?> expectedJson,
      Map<String, ?> expectedForm,
      Map<String, String> expectedHeadersSubset
  ) throws Exception {
    int actualStatus = response.statusCode();
    if (expectedStatus != actualStatus) {
      fail("HTTP status ==> expected: <" + expectedStatus + "> but was: <" + actualStatus + ">\n\nResponse body:\n" + response.asString());
    }

    Map<String, Object> actual = MAPPER.readValue(response.asString(), new TypeReference<>() {});

    // Postman Echo может не включать некоторые поля в зависимости от метода/типа запроса.
    // Нормализуем отсутствующие/нулевые значения к ожидаемым "пустым" значениям.
    assertEquals(
        expectedArgs == null ? Map.of() : expectedArgs,
        asMapOrEmpty(actual.get("args")),
        "args"
    );

    assertEquals(
        expectedData == null ? "" : expectedData,
        asStringOrEmpty(actual.get("data")),
        "data"
    );

    assertEquals(Map.of(), asMapOrEmpty(actual.get("files")), "files");

    assertEquals(
        expectedForm == null ? Map.of() : expectedForm,
        asMapOrEmpty(actual.get("form")),
        "form"
    );

    assertEquals(expectedJson, actual.get("json"), "json");
    assertEquals(expectedUrl, actual.get("url"), "url");

    @SuppressWarnings("unchecked")
    Map<String, Object> headers = (Map<String, Object>) actual.get("headers");

    for (var e : expectedHeadersSubset.entrySet()) {
      assertEquals(e.getValue(), String.valueOf(headers.get(e.getKey())), "headers." + e.getKey());
    }
  }

  @SuppressWarnings("unchecked")
  private static Map<String, Object> asMapOrEmpty(Object value) {
    if (value == null) return Map.of();
    if (value instanceof Map) return (Map<String, Object>) value;
    return Collections.emptyMap();
  }

  private static String asStringOrEmpty(Object value) {
    if (value == null) return "";
    return String.valueOf(value);
  }
}

